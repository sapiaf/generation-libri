package org.generation.libri.generationlibrary.controller.admin;

import jakarta.validation.Valid;
import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.BooksRestockinQuantity;
import org.generation.libri.generationlibrary.model.Restocking;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.BooksRestockinQuantityRepository;
import org.generation.libri.generationlibrary.repository.RestockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
        /*List<BooksRestockinQuantity> avaibleBooksQuantity = new ArrayList<>();
        for (Book b : availableBooks) {
            BooksRestockinQuantity brq = new BooksRestockinQuantity();
            brq.setBook(b);
            brq.setRestock(restocking);
            avaibleBooksQuantity.add(brq);
        }
        restocking.setBooksRestockinQuantity(avaibleBooksQuantity);*/
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
            restockRepository.save(restocking);
            for (int i = 0; i < availableBooks.size(); i++) {
                Integer restockQuantity = restockQuantities[i];
                if (restockQuantity != null) {
                    BooksRestockinQuantity booksRestockinQuantity = new BooksRestockinQuantity();
                    booksRestockinQuantity.setQuantityOfBookStock(restockQuantity);
                    booksRestockinQuantity.setBook(availableBooks.get(i));
                    booksRestockinQuantity.setRestock(restocking);
                    booksRestockinQuantityRepository.save(booksRestockinQuantity);
                }
            }
            return "redirect:/admin/restock";
        } else {
            List<Book> availableBooks = bookRepository.findAll();
            model.addAttribute("availableBooks", availableBooks);
            model.addAttribute("quantityError", true);
            return "admin/restock/createRestock";
        }
    }


}
