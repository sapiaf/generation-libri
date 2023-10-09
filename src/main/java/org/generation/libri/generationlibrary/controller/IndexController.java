package org.generation.libri.generationlibrary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* Homepage - user */
@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping
    public String index() {
        return "/index";
    }
    @GetMapping("/aiuto-faq")
    public String qAndA() { return "/user/info/qa";}
    @GetMapping("/contatti")
    public String contatti() { return "/user/info/contact";}
    @GetMapping("/privacy")
    public String privacy() { return "/user/info/privacy";}
    @GetMapping("/spedizioni")
    public String spedizioni() { return "/user/info/shipping";}
}
