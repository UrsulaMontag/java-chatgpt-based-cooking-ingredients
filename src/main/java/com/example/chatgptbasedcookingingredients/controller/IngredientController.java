package com.example.chatgptbasedcookingingredients.controller;


import com.example.chatgptbasedcookingingredients.services.IngredientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientService service;

    @PostMapping
    String categorizeIngredient(@RequestBody String ingredient) {

        return service.categorizeIngredient(ingredient);
    }

}
