package org.generation.libri.generationlibrary.controller;

import org.generation.libri.generationlibrary.model.Category;
import org.generation.libri.generationlibrary.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/* Crud categorie lato amministrazione*/
@Controller("/admin/categories")
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    //Metodo che mostra la lista delle categories
    @GetMapping
    public String index(Model model){
        model.addAttribute("categoryList", categoryRepository.findAll());
        model.addAttribute("categoryObj", new Category());
        return "/admin/categories/list";
    }
    @PostMapping("/create")
    public String doCreate(@ModelAttribute("categoryObj") Category categoryform, RedirectAttributes redirectAttributes) {
        categoryRepository.save(categoryform);
        redirectAttributes.addFlashAttribute("message", "Categpry succesfully added");

        return "redirect:/admin/categories";
    }
    //Metodo che cancella una categoria
    @PostMapping("/delete/{catId}")
    public String delete(@PathVariable("catId") int id){
        categoryRepository.deleteById(id);
        return "redirect:/admin/categories";
    }
}
