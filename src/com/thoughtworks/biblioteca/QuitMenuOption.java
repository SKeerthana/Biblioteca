package com.thoughtworks.biblioteca;

public class QuitMenuOption implements MenuOption {

    @Override
    public void performOperation() {
        System.exit(0);
    }
}
