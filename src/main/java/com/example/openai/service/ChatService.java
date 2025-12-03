package com.example.openai.service;

import com.example.openai.entity.Answer;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.converter.ListOutputConverter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatClient chatClient;

    // text 바로 받기
    public String chat(String message) {
        return chatClient.prompt() // 프롬프트 생성
                .user(message) // 사용자 메세지
                .call() // 호출
                .content(); // 요청 정보를 받는 부분 (chatResponse의 문자열)
    }

    // chatResponse에서 text 꺼내 받기
    public String chatMessage(String message) {
        return Objects.requireNonNull(chatClient.prompt()
                        .user(message)
                        .call()
                        .chatResponse())
                .getResult()
                .getOutput()
                .getText();
    }

    // placeholer 적용 (user(message)에도 가능)
    public String chatPlace(String message, String subject, String tone) {
        return Objects.requireNonNull(chatClient.prompt()
                        .user(message)
                        .system(sp -> sp.param("subject", subject).param("tone", tone))
                        .call()
                        .chatResponse())
                .getResult()
                .getOutput()
                .getText();
    }

    // chatResponse json 형식으로 받기
    public ChatResponse chatJson(String message, String subject, String tone) {
        return chatClient.prompt()
                .user(message)
                .system(sp -> sp.param("subject", subject).param("tone", tone))
                .call()
                .chatResponse();
    }

    // entity 형식으로 받기
    public Answer chatObject(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .entity(Answer.class);
    }

    public List<String> chatList(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .entity(new ListOutputConverter(new DefaultConversionService()));
    }

    public Map<String, String> chatMap(String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .entity(new ParameterizedTypeReference<>() {
                });
    }
}
