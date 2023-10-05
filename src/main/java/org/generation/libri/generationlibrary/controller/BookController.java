package org.generation.libri.generationlibrary.controller;

/*tutta la crud dei book - ambiente amministrazione*/


import jakarta.validation.Valid;
import org.generation.libri.generationlibrary.model.Book;
import org.generation.libri.generationlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class BookController {
@Autowired

private BookRepository bookRepository;


    // metodo  mostra la lista di tutti i libri
    @GetMapping
    public String index(Model model) {
        List<Book> bookList = bookRepository.findAll();// questa è la lista di libri presa da database
        model.addAttribute("book",bookList); // passo la lista di libri al model
        return "books/list";
    }
    //CREATE DI UN LIBRO
    @GetMapping("/create")
    private String create (Model model){
        // aggiungiamo al model un attributo di tipo Book
            model.addAttribute("book", new Book());

            return "/books/create"; // template
        }

        // metodo che gestisce la POST di creazione di un Book

        @PostMapping("/create")
        public String doCreate(@Valid @ModelAttribute("book") Book bookCreate,
                BindingResult bindingResult) {
            //  bookCreate è un oggetto Book costruito con i dati che arrivano dalla request, quindi dal form create

            // prima di salvare il book verifico che non ci siano errori di validazione
            if (bindingResult.hasErrors()) {
                return "/books/create"; // template
            }
            // per salvare il book su database chiama in aiuto il bookRepository
            bookRepository.save(bookCreate);
            // se il book è stato salvato con successo faccio una redirect alla pagina della lista dei libri
            return "redirect:/books/list";
        }

    //UPDATE DI UN LIBRO
    @GetMapping("/update/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        // cerco su database il libro con quell'id
        Optional<Book> result = bookRepository.findById(id);
        // verifico se il book è presente
        if (result.isPresent()) {
            // passo il Book al model come attributo
            model.addAttribute("book", result.get());
            // ritorno il template con il form di edit
            return "books/update";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza with id " + id + " not found");
        }
    }

    // postmapping che riceve il submit
    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer bookId, @Valid @ModelAttribute("pizza") Book bookUpdate,
                         BindingResult bindingResult) {
        //associo lid dal path variable al book che arriva dal form update
      bookUpdate.setId(bookId);
        // valido i dati
        if (bindingResult.hasErrors()) {
            // si sono verificati degli errori di validazione
            return "/pizze/edit"; // nome del template per ricreare la view
        }
        // salvo il Book
        bookRepository.save(bookUpdate);
        return "redirect:/books/list";
    }

    //DELETE DIUN LIBRO
    @PostMapping("/delete/{id}")
    public String deleteById(@PathVariable Integer id) {
        // cancello il book
        bookRepository.deleteById(id);
        // rimando alla pagina con la lista
        return "redirect:/book/list";
    }
}
