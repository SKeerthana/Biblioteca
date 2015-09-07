package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//Has the list of menu options for Biblioteca
public class Menu {
    private ArrayList<String> listOfMenuOptions = new ArrayList<String>() {{
        add("1. List all the books");
        add("2. Quit");
        add("3. Checkout books");
    }};

    public String getMenuOptions() {
        String menuOptions = "Choose one of the menu option :\n";
        for (String menuOption : listOfMenuOptions) {
            menuOptions += menuOption + "\n";
        }
        return menuOptions;
    }

    public void handleSelectedMenuOption(MenuOption menuOption) {
        menuOption.performOperation();
    }
}
