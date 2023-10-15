package org.generation.libri.generationlibrary.controller.admin;

import jakarta.validation.Valid;
import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.BooksRestockinQuantity;
import org.generation.libri.generationlibrary.model.Restocking;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.BooksRestockinQuantityRepository;
import org.generation.libri.generationlibrary.repository.RestockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/*pagina restock lato amministrazione */
@Controller
@RequestMapping("/admin/restock")
public class RestockController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RestockRepository restockRepository;
    @Autowired
    private BooksRestockinQuantityRepository booksRestockinQuantityRepository;

    @GetMapping
    public String showRestocks(Model model) {
        List<Restocking> restocks = restockRepository.findAll();
        model.addAttribute("restocks", restocks);
        return "admin/restock/restock";
    }

    @GetMapping("/create")
    public String createRestock(Model model) {
        List<Book> availableBooks = bookRepository.findAll();
        model.addAttribute("availableBooks", availableBooks);
        Restocking restocking = new Restocking();
        restocking.setDateOfStock(LocalDateTime.now());
        model.addAttribute("restocking", restocking);
        return "admin/restock/createRestock";
    }

    @PostMapping("/create")
    public String handleRestockFormSubmission(@Valid @ModelAttribute Restocking restocking,
                                              BindingResult bindingResult,
                                              @RequestParam(name = "restockQuantity", required = false) Integer[] restockQuantities,
                                              Model model
    ) {
        if (bindingResult.hasErrors()) {
            List<Book> availableBooks = bookRepository.findAll();
            model.addAttribute("availableBooks", availableBooks);
            return "admin/restock/createRestock";
        }

        boolean allQuantitiesNull = true;
        if (restockQuantities != null) {
            for (Integer quantity : restockQuantities) {
                if (quantity != null) {
                    allQuantitiesNull = false;
                    break;
                }
            }
        }

        if (!allQuantitiesNull) {
            List<Book> availableBooks = bookRepository.findAll();
            List<BooksRestockinQuantity> booksRestockinQuantities = new ArrayList<>();

            for (int i = 0; i < availableBooks.size(); i++) {
                Integer restockQuantity = restockQuantities[i];
                if (restockQuantity != null) {
                    BooksRestockinQuantity booksRestockinQuantity = new BooksRestockinQuantity();
                    booksRestockinQuantity.setQuantityOfBookStock(restockQuantity);
                    booksRestockinQuantity.setBook(availableBooks.get(i));
                    booksRestockinQuantity.setRestock(restocking);
                    booksRestockinQuantities.add(booksRestockinQuantity);
                    Book book = availableBooks.get(i);
                    int newAvailableCopies = book.getCopies() + restockQuantity;
                    book.setCopies(newAvailableCopies);
                    bookRepository.save(book);
                }
            }

            restocking.calculateBulkPriceAndTotalCopies(booksRestockinQuantities);
            restockRepository.save(restocking);

            for (BooksRestockinQuantity brq : booksRestockinQuantities) {
                booksRestockinQuantityRepository.save(brq);
            }

            return "redirect:/admin/restock";
        } else {
            List<Book> availableBooks = bookRepository.findAll();
            model.addAttribute("availableBooks", availableBooks);
            model.addAttribute("quantityError", true);
            return "admin/restock/createRestock";
        }
    }


    @GetMapping("/showRestock/{restockId}")
    public String show(@PathVariable("restockId") Integer id, Model model) {
        Optional<Restocking> restockingOptional = restockRepository.findById(id);
        if (restockingOptional.isPresent()) {
            Restocking restockingFound = restockingOptional.get();
            model.addAttribute("restock", restockingFound);
            return "admin/restock/detailsRestock";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/update/{restockId}")
    public String edit(@PathVariable("restockId") Integer id, Model model) {
        Optional<Restocking> result = restockRepository.findById(id);
        if (result.isPresent()) {
            Restocking restocking = result.get();
            model.addAttribute("restock", restocking);
            model.addAttribute("booksRestockinQuantity", restocking.getBooksRestockinQuantity());
            return "admin/restock/updateRestock";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "restock with id " + id + " not found");
        }
    }

    @PostMapping("/update/{restockId}")
    public String doEdit(@PathVariable("restockId") Integer id,
                         @ModelAttribute("restock") Restocking restockUpdate, Model model) {
        restockUpdate.setId(id);
        Optional<Restocking> result = restockRepository.findById(id);
        Restocking existingRestock;
        if (result.isPresent()) {
            existingRestock = result.get();
            existingRestock.setBooksRestockinQuantity(restockUpdate.getBooksRestockinQuantity());
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        existingRestock.calculateBulkPriceAndTotalCopies(restockUpdate.getBooksRestockinQuantity());
        restockRepository.save(existingRestock);
        List<Restocking> restocks = restockRepository.findAll();
        model.addAttribute("restocks", restocks);

        return "redirect:/admin/restock";
    }

    @PostMapping("/delete/{restockId}")
    public String deleteById(@PathVariable("restockId") Integer id) {
        restockRepository.deleteById(id);
        return "redirect:/admin/restock";
    }
}
