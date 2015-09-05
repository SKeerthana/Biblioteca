package com.thoughtworks.biblioteca;

public class Menu {

    public String getMenuOptions() {
        String menuOptions = "Menu options :\n";
        menuOptions += "1. List all the books\n";
        return menuOptions;
    }

    public int handleSelectedMenuOption(int choice) {
        switch (choice) {
            case 1:
                return 1;
            default:
                return 0;
        }
    }
}
