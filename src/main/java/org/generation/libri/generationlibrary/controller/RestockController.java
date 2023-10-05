package org.generation.libri.generationlibrary.controller;

import jakarta.validation.Valid;
import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.Restocking;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.RestockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

/*pagina restock lato amministrazione */
@Controller
@RequestMapping("/admin")
public class RestockController {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestockRepository restockRepository;

    @GetMapping("/restock")
    public String createRestock(@RequestParam("bookId") Integer bookId, Model model) {
        if (bookRepository.findById(bookId).isPresent()) {
            Book book = bookRepository.findById(bookId).get();
            Restocking restocking = new Restocking();
            restocking.setBook(book);
            restocking.setSuppliedCopies(1);
            model.addAttribute("book", book);
            model.addAttribute("restocking", restocking);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return "/admin/books/restock";
    }

    @PostMapping("/restock/{bookId}")
    public String doCreateRestock(@Valid @PathVariable("bookId") Integer bookId, @ModelAttribute("restocking") Restocking restocking, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/books/restock";
        }
        restockRepository.save(restocking);
        return "redirect:/admin/books/list";
    }


}
