package com.example.openai.askChat.controller;


import com.example.openai.askChat.service.AskChatService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AskController {

    private final AskChatService chatService;

    @GetMapping("/ask")
    public String getResponse(String message) {
        return chatService.getResponse(message);
    }

    @GetMapping("/ask-ai")
    public String getResponseOptions(String message) {
        return chatService.getResponseOptions(message);
    }
}
