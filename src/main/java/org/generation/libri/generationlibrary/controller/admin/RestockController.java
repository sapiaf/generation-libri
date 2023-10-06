package org.generation.libri.generationlibrary.controller.admin;

import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.model.Restocking;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.RestockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    /*PROBLEMA GESTIONE NUMERO DI COPIE PER OGNI LIBRO- BISOGNA
      CAPIRE SE C'È UN PROBLEMA CON LA REALZIONE O SE BISOGNA
      TRASFORMARE SUPPLIES COPIES IN UNA LISTA */
    @GetMapping("/create")
    public String createRestock(Model model) {
        List<Book> availableBooks = bookRepository.findAll();
        model.addAttribute("availableBooks", availableBooks);
        model.addAttribute("restocking", new Restocking());
        return "admin/restock/createRestock";
    }

    @PostMapping("/create")
    public String doCreateRestock(@ModelAttribute Restocking restocking,
                                  @RequestParam List<Integer> booksListRestock,
                                  @RequestParam List<Integer> suppliedCopies) {
        List<Book> selectedBooks = new ArrayList<>();
        for (Integer bookId : booksListRestock) {
            Book book = bookRepository.findById(bookId).orElseThrow();
        }
        restocking.setBooksListRestock(selectedBooks);
        int totalSuppliedCopies = suppliedCopies.stream().mapToInt(Integer::intValue).sum();
        restocking.setSuppliedCopies(totalSuppliedCopies);
        restockRepository.save(restocking);
        return "redirect:/admin/restocks";
    }


}
