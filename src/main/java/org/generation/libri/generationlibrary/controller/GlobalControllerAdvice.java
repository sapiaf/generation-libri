package org.generation.libri.generationlibrary.controller;

import org.generation.libri.generationlibrary.model.Category;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.CategoryRepository;
import org.generation.libri.generationlibrary.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@ControllerAdvice
public class GlobalControllerAdvice {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ReviewRepository reviewRepository;

    @ModelAttribute
    public void globalAttributes(Model model) {
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("categories", categories);
    }
}
