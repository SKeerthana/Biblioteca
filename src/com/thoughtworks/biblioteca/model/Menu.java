package com.thoughtworks.biblioteca.model;

import java.util.ArrayList;
import com.thoughtworks.biblioteca.user.User;
import com.thoughtworks.biblioteca.options.MenuOption;

//Has the list of menu options for Library
public class Menu {
    private ArrayList<String> listOfMenuOptions;

    public Menu(ArrayList<String> listOfMenuOptions) {
        this.listOfMenuOptions = listOfMenuOptions;
    }

    public String getMenuOptionsToDisplay(User user) {
        String menuOptions = "Choose one of the menu option :\n";
        listOfMenuOptions = user.getMenuOptions();
        for (int index = 0; index < listOfMenuOptions.size(); index++) {
            menuOptions += index+1 + ".\t" + listOfMenuOptions.get(index) + "\n";
        }
        return menuOptions;
    }

    public void handleSelectedMenuOption(MenuOption menuOption) {
        menuOption.performOperation();
    }
}
