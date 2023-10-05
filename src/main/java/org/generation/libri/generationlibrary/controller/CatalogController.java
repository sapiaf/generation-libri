package org.generation.libri.generationlibrary.controller;

import jakarta.validation.Valid;
import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.generation.libri.generationlibrary.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

/* Catalogo libri con search per l'user */
@Controller
@RequestMapping("/user")
public class CatalogController {

    @Autowired
    private CatalogRepository catalogRepository;
private BookRepository bookRepository;
//LISTA DEI LIBRI PER I CLIENTI
    @GetMapping
    public String index(Model model) {
        List<Book> bookcatalog = bookRepository.findAll();//  lista di libri presa da database
        model.addAttribute("book",bookcatalog); // passo la lista di libri al model
        return "/catalog";
    }
    //metodo show che mostra il detaglio di un libro  preso per id
    @GetMapping("/show/{bookId}")
    public String show(@PathVariable("bookId")Integer id, Model model){
        Optional<Book> bookOptional=bookRepository.findById(id);
        if(bookOptional.isPresent()){
            Book bookFound=bookOptional.get();
            model.addAttribute("book",bookFound);
            return "/details";
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
