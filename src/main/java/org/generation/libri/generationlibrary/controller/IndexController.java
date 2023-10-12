package org.generation.libri.generationlibrary.controller;

import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/* Homepage - user */
@Controller
@RequestMapping("/")
public class IndexController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    PurchaseRepository purchaseRepository;


    @GetMapping
    public String index(Model model) {
        List<Book> bookList = filterDeletedBooks(bookRepository.findAllByOrderByDateOfPublishingDesc());
        List<Book> narrativaBooks = filterDeletedBooks(bookRepository.findByCategories_Id(1));
        List<Book> fantasyBooks = filterDeletedBooks(bookRepository.findByCategories_Id(5));
        List<Book> classiciBooks = filterDeletedBooks(bookRepository.findByCategories_Id(2));
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minusMonths(1);
        List<Book> topSellingBooks = filterDeletedBooks(purchaseRepository.findTopSellingBooksInDateRange(startDate, endDate));

        model.addAttribute("narrativaBooks", narrativaBooks);
        model.addAttribute("fantasyBooks", fantasyBooks);
        model.addAttribute("classiciBooks", classiciBooks);
        model.addAttribute("topSellingBooks", topSellingBooks);
        model.addAttribute("books", bookList);

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

    private List<Book> filterDeletedBooks(List<Book> books) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (!book.isDeleteTrue()) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
}
