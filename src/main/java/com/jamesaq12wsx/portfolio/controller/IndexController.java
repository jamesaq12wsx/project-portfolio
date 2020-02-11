package com.jamesaq12wsx.portfolio.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("datetime", new Date());
        model.addAttribute("firstname", "SHAOCHIN");
        model.addAttribute("lastname", "LIN");
        model.addAttribute("address", "3542 Berry Street · Cheyenne Wells, CO 80810");
        model.addAttribute("phone", "6267660527");
        model.addAttribute("email", "jamesaq12wsx@gmail.com");

        return "index";
    }
}
