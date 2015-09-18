package com.thoughtworks.biblioteca.options;

//quits the application
public class QuitMenuOption implements MenuOption {

    @Override
    public void performOperation() {
        System.exit(0);
    }
}
