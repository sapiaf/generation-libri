package org.generation.libri.generationlibrary.controller.admin;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

/* Crud categorie lato amministrazione*/
@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categoryList", categoryRepository.findAll());
        model.addAttribute("categoryObj", new Category());
        return "/admin/categories/list";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("categoryObj") Category categoryform, RedirectAttributes redirectAttributes) {
        categoryRepository.save(categoryform);
        redirectAttributes.addFlashAttribute("message", "Category succesfully added");
        return "redirect:/admin/categories";
    }

    @GetMapping("/update/{catId}")
    public String update(@PathVariable Integer catId, Model model) {
        Optional<Category> result = categoryRepository.findById(catId);
        if (result.isPresent()) {
            model.addAttribute("category", result.get());
            return "/admin/categories/update";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category with id " + catId + " not found");
        }
    }

    @PostMapping("/update/{catId}")
    public String doUpdate(@PathVariable Integer id, @Valid @ModelAttribute("category") Category categoryForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/admin/categories/update";
        }
        categoryRepository.save(categoryForm);
        return "redirect:/admin/categories/list";
    }

    @PostMapping("/delete/{catId}")
    public String deleteSpecialOffer(@PathVariable("catId") Integer id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            for (Book book : category.getBooks()) {
                book.getCategories().remove(category);
                bookRepository.save(book);
            }
            category.getBooks().clear();
            categoryRepository.save(category);
            categoryRepository.deleteById(id);
            return "redirect:/admin/categories";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    //SEARCH
}
