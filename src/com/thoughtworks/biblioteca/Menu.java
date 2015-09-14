package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//Has the list of menu options for Biblioteca
public class Menu {
    private ArrayList<String> listOfMenuOptions;

    public Menu(ArrayList<String> listOfMenuOptions) {
        this.listOfMenuOptions = listOfMenuOptions;
    }

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
