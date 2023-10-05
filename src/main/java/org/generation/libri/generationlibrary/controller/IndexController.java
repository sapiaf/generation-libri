package org.generation.libri.generationlibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* Homepage - user */
@Controller
@RequestMapping("/home")
public class IndexController {

    @GetMapping
    private String index(){
        return "/index";
    }
}
