package org.generation.libri.generationlibrary.controller;

/*tutta la crud dei book - ambiente amministrazione*/

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class BookController {

    //CREATE
    @GetMapping("/create")
    private String create (){
        return "/admin/books/create";
    }

    //UPDATE

    //DELETE

}
