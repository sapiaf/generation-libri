package org.generation.libri.generationlibrary.controller;

import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/* Homepage - user */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    BookRepository bookRepository;


    @GetMapping
    public String index(Model model) {
        List<Book> bookList = bookRepository.findAll();
        List<Book> bookSelected = new ArrayList<>();
        for (Book book : bookList) {
            if (!book.isDeleteTrue()) {
                bookSelected.add(book);
            }
        }
        model.addAttribute("books", bookSelected);
        return "/index";
    }


    @GetMapping("/aiuto-faq")
    public String qAndA() {
        return "/user/info/qa";
    }

    @GetMapping("/contatti")
    public String contatti() {
        return "/user/info/contact";
    }

    @GetMapping("/privacy")
    public String privacy() {
        return "/user/info/privacy";
    }

    @GetMapping("/spedizioni")
    public String spedizioni() {
        return "/user/info/shipping";
    }
}
