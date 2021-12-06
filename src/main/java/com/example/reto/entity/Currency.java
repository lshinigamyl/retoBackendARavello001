package com.example.reto.entity;

public enum Currency {
    PEN("Nuevo Sol"),
    USD("Dollar Americano"),
    EUR("Euro");

    private String description;

    Currency(String description){
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }
}