package com.example.chatgptbasedcookingingredients.models;

import java.util.List;

/**
 * {
 * "choices": [
 * {
 * "message": {
 * "role": "assistant",
 * "content": "This is a test!"
 * },
 * }
 * ],
 * }
 */
public record OpenAIResponse(List<OpenAIChoices> choices) {

    public String getAnswer() {
        return choices.getFirst().message().content();
    }
}
