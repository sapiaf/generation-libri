package org.generation.libri.generationlibrary.controller.user;

import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.Category;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.CategoryRepository;
import org.generation.libri.generationlibrary.repository.PurchaseRepository;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping
    public String index(@RequestParam(value = "query", required = false) Optional<String> searchKeyword,
                        @RequestParam(value = "minPrice", required = false) Optional<BigDecimal> minPrice,
                        @RequestParam(value = "maxPrice", required = false) Optional<BigDecimal> maxPrice,
                        @RequestParam(value = "minYear", required = false) Optional<Integer> minYear,
                        @RequestParam(value = "maxYear", required = false) Optional<Integer> maxYear,
                        @RequestParam(value = "categories", required = false) List<Integer> categoryIds,
                        Model model) {

        List<Book> bookCatalog = searchBooks(searchKeyword, minPrice, maxPrice, minYear, maxYear, categoryIds);
        List<Book> bookSelected = new ArrayList<>();
        for (Book book : bookCatalog) {
            if (!book.isDeleteTrue()) {
                bookSelected.add(book);
            }
        }
        model.addAttribute("book", bookSelected);
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("selectedCategoryIds", categoryIds);
        model.addAttribute("breadcrumbTitle", "Catalogo");
        return "user/catalog";
    }


    @GetMapping("/show/{bookId}")
    public String show(@PathVariable("bookId") Integer id, Model model) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()) {
            Book bookFound = bookOptional.get();

            List<Category> categories = bookFound.getCategories();
            if (categories == null || categories.isEmpty()) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No categories found for the book");
            }
            Integer categoryId = categories.get(0).getId();

            model.addAttribute("book", bookFound);
            model.addAttribute("relatedBooks", getRelatedBooks(bookFound, categoryId));

            return "user/details";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/bestsellers")
    public String bestsellers(Model model) {
        LocalDateTime endDate = LocalDateTime.now();
        LocalDateTime startDate = endDate.minusMonths(1);
        List<Book> bookCatalog = purchaseRepository.findTopSellingBooksInDateRange(startDate, endDate);
        model.addAttribute("books", bookCatalog);
        return "user/bestsellers";
    }

    @GetMapping("/new")
    public String newentry(Model model) {
        List<Book> newBooks = bookRepository.findAllByOrderByDateOfPublishingDesc();
        model.addAttribute("book", newBooks);
        model.addAttribute("breadcrumbTitle", "Novità");
        return "user/catalog";
    }


    @GetMapping("/category/{categoryId}")
    public String showBooksByCategory(@PathVariable("categoryId") Integer categoryId, Model model) {
        List<Book> booksByCategory = bookRepository.findByCategories_Id(categoryId);
        List<Category> categoryCatalog = categoryRepository.findAll();
        Optional<Category> breadcrumbCategory = categoryRepository.findById(categoryId);
        model.addAttribute("book", booksByCategory);
        model.addAttribute("categories", categoryCatalog);
        model.addAttribute("breadcrumbTitle", breadcrumbCategory.get().getName());
        model.addAttribute("selectedCategoryId", categoryId);
        return "user/catalog";
    }


    private List<Book> searchBooks(Optional<String> keyword, Optional<BigDecimal> minPrice, Optional<BigDecimal> maxPrice, Optional<Integer> minYear, Optional<Integer> maxYear, List<Integer> categoryIds) {

        if (keyword.isPresent()) {
            return bookRepository.findByNameContainingIgnoreCase(keyword.get());
        }

        BigDecimal fairMinPrice = minPrice.orElse(BigDecimal.valueOf(0));
        BigDecimal fairMaxPrice = maxPrice.orElse(BigDecimal.valueOf(Double.MAX_VALUE));
        Integer fairMinYear = minYear.orElse(0);
        Integer fairMaxYear = maxYear.orElse(Integer.MAX_VALUE);

        if (categoryIds != null && !categoryIds.isEmpty()) {
            return bookRepository.findByCategories_IdInAndPriceBetweenAndDateOfPublishingBetween(categoryIds, fairMinPrice, fairMaxPrice, fairMinYear, fairMaxYear);
        }

        return bookRepository.findByPriceBetweenAndDateOfPublishingBetween(fairMinPrice, fairMaxPrice, fairMinYear, fairMaxYear);
    }

    private List<Book> getRelatedBooks(Book book, Integer categoryId) {
        List<Book> allRelatedBooks = bookRepository.findByCategories_Id(categoryId);
        List<Book> relatedBooks = new ArrayList<>();
        for (Book relatedBook : allRelatedBooks) {
            if (!relatedBook.getId().equals(book.getId())) {
                relatedBooks.add(relatedBook);
            }
            if (relatedBooks.size() == 4) {
                break;
            }
        }
        return relatedBooks;
    }

}
