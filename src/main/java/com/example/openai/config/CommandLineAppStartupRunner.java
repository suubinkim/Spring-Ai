package com.example.openai.config;

import com.example.openai.service.ChatService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final ChatService chatService;

    @Override
    public void run(String... args) {
        chatService.startChat();
    }
}
