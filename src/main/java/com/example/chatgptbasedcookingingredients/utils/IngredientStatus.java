package com.example.chatgptbasedcookingingredients.utils;

public enum IngredientStatus {
    VEGAN("vegan"),
    VEGETARIAN("vegetarian"),
    NORMAL("normal");

    private final String statusNormal;

    IngredientStatus(String statusNormal) {
        this.statusNormal = statusNormal;
    }

    public String getStatusNormal() {
        return statusNormal;
    }

}
