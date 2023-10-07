package org.generation.libri.generationlibrary.controller.admin;

import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.BooksRestockinQuantity;
import org.generation.libri.generationlibrary.model.Restocking;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.BooksRestockinQuantityRepository;
import org.generation.libri.generationlibrary.repository.RestockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
        model.addAttribute("restocking", restocking);
        return "admin/restock/createRestock";
    }

    @PostMapping("/create")
    public String handleRestockFormSubmission(@ModelAttribute Restocking restocking,
                                              @RequestParam("restockQuantity") Integer[] restockQuantities,
                                              @RequestParam("paymentMethod") String paymentMethod) {
        List<Book> availableBooks = bookRepository.findAll();
        restocking.setPaymentMethod(paymentMethod);
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
    }


}
