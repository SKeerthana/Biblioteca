package com.thoughtworks.biblioteca;

public class Biblioteca {

    private String getWelcomeMessage() {
        return "Welcome to Biblioteca";
    }

    public void start() {
        System.out.print(getWelcomeMessage());
    }
}
