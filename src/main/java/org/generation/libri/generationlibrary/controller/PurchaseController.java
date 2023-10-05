package org.generation.libri.generationlibrary.controller;

import jakarta.validation.Valid;
import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.Purchase;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

/*Pagina Acquisto lato user*/

@Controller
@RequestMapping("/")
public class PurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/purchase")
    public String purchase(@RequestParam("bookId") Integer bookId, Model model) {
        Optional<Book> bookResult = bookRepository.findById(bookId);
        if (bookResult.isPresent()) {
            Book book = bookRepository.findById(bookId).get();
            Purchase purchase = new Purchase();
            purchase.setBook(book);
            purchase.setPurchaseQuantity(1);
            model.addAttribute("book", book);
            model.addAttribute("purchase", purchase);
            return "/user/purchase";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/purchase/{bookId}")
    public String doPurchase(@Valid @PathVariable("bookId") Integer bookId, @ModelAttribute("purchase")
    Purchase purchase, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/user/purchase";
        }
        Book book = bookRepository.findById(bookId).get();
        book.setCopies(book.getCopies() - purchase.getPurchaseQuantity());
        purchaseRepository.save(purchase);
        return "/user/purchasesucces";
    }
}
