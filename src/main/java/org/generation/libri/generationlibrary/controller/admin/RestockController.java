package org.generation.libri.generationlibrary.controller.admin;

import org.generation.libri.generationlibrary.model.Restocking;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.RestockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/*pagina restock lato amministrazione */
@Controller
@RequestMapping("/admin/restock")
public class RestockController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RestockRepository restockRepository;

    @GetMapping
    public String showRestocks(Model model) {
        List<Restocking> restocks = restockRepository.findAll();
        model.addAttribute("restocks", restocks);
        return "admin/restock/restock";
    }

}
