package com.example.chatgptbasedcookingingredients.models;

import lombok.Data;

import java.util.List;

/**
 * {
 * "model": "gpt-3.5-turbo",
 * "messages": [{"role": "user", "content": "Say this is a test!"}], "temperature": 0.7
 * }
 */

@Data
public class OpenAIRequest {
    private final List<OpenAIMessage> messages;
    private String model;
    private double temperature;

    public OpenAIRequest(List<OpenAIMessage> messages) {
        this.messages = messages;
        this.model = "gpt-3.5-turbo";
        this.temperature = 0.5;
    }
}
