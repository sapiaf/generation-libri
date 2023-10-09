package org.generation.libri.generationlibrary.controller.admin;

/*tutta la crud dei book - ambiente amministrazione*/


import jakarta.validation.Valid;
import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.Category;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class BookController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String index(Model model) {
        List<Book> bookList = bookRepository.findAll();
        model.addAttribute("book", bookList);
        return "admin/books/list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        return "admin/books/create";
    }

    @PostMapping("/create")
    public String doCreate(@Valid @ModelAttribute("book") Book bookCreate,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/books/create";
        }
        bookRepository.save(bookCreate);
        return "redirect:/admin";
    }


    @GetMapping("/show/{bookId}")
    public String show(@PathVariable("bookId") Integer id, Model model) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book bookFound = bookOptional.get();
            model.addAttribute("book", bookFound);
            return "admin/books/details";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/update/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Book> result = bookRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("book", result.get());
            return "admin/books/update";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "book with id " + id + " not found");
        }
    }

    @PostMapping("/update/{id}")
    public String doEdit(@PathVariable Integer id, @Valid @ModelAttribute("book") Book bookUpdate,
                         BindingResult bindingResult) {
        bookUpdate.setId(id);
        if (bindingResult.hasErrors()) {
            return "admin/books/update";
        }
        bookRepository.save(bookUpdate);
        return "redirect:/admin";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        bookRepository.deleteById(id);
        return "redirect:/admin";
    }
}
