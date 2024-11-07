package com.ontu.lab6.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller

public class WebController {

    

    @RequestMapping(value = "/index")

    public String index(Model model) {

        String[][] board = {

            {"X", "X", ""},

            {"", "X", ""},

            {"0", "0", "0"}

        };

        

        model.addAttribute("board", board);

        return "index";

    }

}

