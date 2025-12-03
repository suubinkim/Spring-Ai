package com.example.openai.controller;


import com.example.openai.entity.Answer;
import com.example.openai.service.ChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/chat")
    public String chat(@RequestParam("message") String message) {
        return chatService.chat(message);
    }

    @GetMapping("/chat-message")
    public String chatMessage(@RequestParam String message) {
        return chatService.chatMessage(message);
    }

    @GetMapping("/chat-place")
    public String chatPlace(@RequestParam String message, @RequestParam String subject, @RequestParam String tone) {
        return chatService.chatPlace(message, subject, tone);
    }

    @GetMapping("/chat-json")
    public ChatResponse chatJson(@RequestParam String message, @RequestParam String subject, @RequestParam String tone) {
        return chatService.chatJson(message, subject, tone);
    }

    @GetMapping("/chat-object")
    public Answer chatObject(@RequestParam String message) {
        return chatService.chatObject(message);
    }

    @GetMapping("chat-list")
    public List<String> chatList(@RequestParam String message) {
        return chatService.chatList(message);
    }

    @GetMapping("chat-map")
    public Map<String, String> chatMap(@RequestParam String message) {
        return chatService.chatMap(message);
    }
}
