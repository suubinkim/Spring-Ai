package com.example.openai.askChat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouteController {

    @GetMapping("/ask-view")
    public String askView() {
        return "ask";
    }
}
