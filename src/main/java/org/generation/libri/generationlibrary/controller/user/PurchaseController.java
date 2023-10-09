package org.generation.libri.generationlibrary.controller.user;

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

import java.math.BigDecimal;
import java.time.LocalDateTime;


import java.util.Optional;

/*Pagina Acquisto lato user*/

@Controller
@RequestMapping("/")
public class PurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private BookRepository bookRepository;

    /*CREAZIONE ORDINE LATO UTENTE */
    @GetMapping("/purchase/{bookId}")
    public String createPurchase(@PathVariable("bookId") Integer bookId, Model model) {
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
    public String doCreatePurchase(
            @Valid @PathVariable("bookId") Integer bookId,
            @ModelAttribute("purchase") Purchase purchase,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "/user/purchase";
        }
        Book book = bookRepository.findById(bookId).get();
        model.addAttribute("book", book);
        purchase.setBook(book);
        purchase.setDateOfPurchase(LocalDateTime.now());
        BigDecimal calculatedPrice = book.getPrice().multiply(BigDecimal.valueOf(purchase.getPurchaseQuantity()));
        purchase.setTotalPrice(calculatedPrice);
        book.setCopies(book.getCopies() - purchase.getPurchaseQuantity());
        bookRepository.save(book);
        purchaseRepository.save(purchase);
        return "/user/purchase";
    }
}
