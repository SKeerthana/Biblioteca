package com.thoughtworks.biblioteca;
//Has the list of menu options for Biblioteca
public class Menu {
    private Biblioteca biblioteca;
    private Display display;

    public Menu(Biblioteca biblioteca, Display display) {
        this.biblioteca = biblioteca;
        this.display = display;
    }

    public String getMenuOptions() {
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "1. List all the books\n";
        menuOptions += "2. Quit\n";
        return menuOptions;
    }

    public void handleSelectedMenuOption(int choice) {
        switch (choice) {
            case 1:
                display.printMessage(biblioteca.getListOfBooks());
                break;
            case 2:
                Quit();
            default:
                display.printMessage("Select a valid option!\n");
        }
    }

    private void Quit() {
        System.exit(0);
    }
}
