package com.example.chatgptbasedcookingingredients.services;

import com.example.chatgptbasedcookingingredients.models.OpenAIMessage;
import com.example.chatgptbasedcookingingredients.models.OpenAIRequest;
import com.example.chatgptbasedcookingingredients.models.OpenAIResponse;
import com.example.chatgptbasedcookingingredients.utils.IngredientStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class IngredientService {

    private final RestClient client;

    public IngredientService(@Value("${OPENAI_URL}") String baseUrl,
                             @Value("${OPENAI_AUTH_KEY}") String key) {
        client = RestClient.builder()
                .defaultHeader("Authorization", "Bearer " + key)
                .baseUrl(baseUrl)
                .build();
    }

    public String categorizeIngredient(String ingredient) throws NullPointerException {
        String requestMessage = "Please categorise following ingredient in category " + IngredientStatus.VEGAN + ", "
                + IngredientStatus.VEGETARIAN + " or " + IngredientStatus.NORMAL + ". Ingredient: " + ingredient;
        OpenAIRequest request = new OpenAIRequest(List.of(new OpenAIMessage("user", requestMessage)));
        OpenAIResponse response = client.post()
                .contentType(MediaType.APPLICATION_JSON)
                .body(request)
                .retrieve()
                .body(OpenAIResponse.class);


        if (response != null) {
            return "The given ingredient is " + response.getAnswer();
        }
        throw new NullPointerException("Could not get response");
    }
}
