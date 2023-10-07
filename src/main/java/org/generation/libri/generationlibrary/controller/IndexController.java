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

    @GetMapping("/qa")
    public String qAndA() { return "/user/info/qa";}
}
