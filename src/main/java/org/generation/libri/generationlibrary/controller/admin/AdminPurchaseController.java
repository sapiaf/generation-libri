package org.generation.libri.generationlibrary.controller.admin;

import jakarta.validation.Valid;
import org.generation.libri.generationlibrary.model.Purchase;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin/purchase")
public class AdminPurchaseController {
    @Autowired
    private PurchaseRepository purchaseRepository;
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public String listOfPurchase(Model model) {
        List<Purchase> purchasesList = purchaseRepository.findAll();
        model.addAttribute("purchases", purchasesList);
        return "admin/purchase/purchaseList";
    }

    @GetMapping("/show/{acquistoId}")
    public String show(@PathVariable("acquistoId") Integer id, Model model) {
        Optional<Purchase> purchaseOptional = purchaseRepository.findById(id);
        if (purchaseOptional.isPresent()) {
            Purchase purchaseFound = purchaseOptional.get();
            model.addAttribute("purchase", purchaseFound);
            return "admin/purchase/purchaseDetails";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Integer id, Model model) {
        Optional<Purchase> result = purchaseRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("purchase", result.get());
            model.addAttribute("books", bookRepository.findAll());
            return "/admin/purchase/purchaseEdit";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Purchase with id " + id + " not found");
        }
    }

    @PostMapping("/update/{id}")
    public String doUpdate(@PathVariable Integer id, @Valid @ModelAttribute("purchase") Purchase purchaseUpdate,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/purchase/purchaseEdit";
        }
        purchaseRepository.save(purchaseUpdate);
        return "redirect:/admin/purchase";
    }

    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        purchaseRepository.deleteById(id);
        return "redirect:/admin/purchase";
    }

    @GetMapping("/search")
    public String search(@RequestParam("queryPurchase") String searchString, Model model) {
        List<Purchase> purchasesList = purchaseRepository.searchListPurchase(searchString);
        model.addAttribute("purchases", purchasesList);
        return "/admin/purchase/purchaseList";
    }

    @GetMapping("/datefilter")
    public String dateFilter(@RequestParam("minDate") LocalDate minDate, @RequestParam("maxDate") LocalDate maxDate, Model model) {
        List<Purchase> purchaseDateList = purchaseRepository.searchListBetweenDates(minDate, maxDate);
        model.addAttribute("purchases", purchaseDateList);
        return "admin/purchase/purchaseList";
    }
}
