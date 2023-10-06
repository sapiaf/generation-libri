package org.generation.libri.generationlibrary.controller.user;

import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.Category;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

/* Catalogo libri con search per l'user */
@Controller
@RequestMapping("/catalog")
public class CatalogController {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public String index(@RequestParam(value = "query", required = false) Optional<String> searchKeyword,
                        @RequestParam(value = "minPrice", required = false) Optional<BigDecimal> minPrice,
                        @RequestParam(value = "maxPrice", required = false) Optional<BigDecimal> maxPrice,
                        Model model) {
        List<Book> bookCatalog;
        String keyword = "";
        if (searchKeyword.isPresent()) {
            keyword = searchKeyword.get();
            bookCatalog = bookRepository.findByNameContainingIgnoreCase(keyword);
        } else if (minPrice.isPresent() && maxPrice.isPresent()) {
            bookCatalog = bookRepository.findByPriceBetween(minPrice.get(), maxPrice.get());
        } else {
            bookCatalog = bookRepository.findAll();
        }

        model.addAttribute("book", bookCatalog);
        List<Category> categoryCatalog = categoryRepository.findAll();
        model.addAttribute("categories", categoryCatalog);
        return "user/catalog";
    }



    @GetMapping("/show/{bookId}")
    public String show(@PathVariable("bookId") Integer id, Model model) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book bookFound = bookOptional.get();
            model.addAttribute("book", bookFound);
            return "user/details";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/category/{categoryId}")
    public String showBooksByCategory(@PathVariable("categoryId") Integer categoryId, Model model) {
        List<Book> booksByCategory = bookRepository.findByCategories_Id(categoryId);
        model.addAttribute("book", booksByCategory);
        List<Category> categoryCatalog = categoryRepository.findAll();
        model.addAttribute("categories", categoryCatalog);
        model.addAttribute("selectedCategoryId", categoryId);
        return "user/catalog";
    }

}
