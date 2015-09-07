package com.thoughtworks.biblioteca;

public class MenuOptionController {
    private Menu menu;
    private Biblioteca biblioteca;
    private Display display;

    public MenuOptionController(Menu menu, Biblioteca biblioteca, Display display) {
        this.menu = menu;
        this.biblioteca = biblioteca;
        this.display = display;
    }

    public void displayMenuOption() {
        display.printMessage(menu.getMenuOptions());
    }

    public void handleMenuOption(int option) {
        MenuOption menuOption = getMenuOption(option);
        menu.handleSelectedMenuOption(menuOption);
    }

    private MenuOption getMenuOption(int option) {
        switch (option) {
            case 1:
                return new ListBooksMenuOption(biblioteca, display);
            case 2:
                return new QuitMenuOption();
            default:
                return new InvalidMenuOption(display);
        }
    }
}
