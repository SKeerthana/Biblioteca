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

    public void handleMenuOption() {
        int option = Integer.parseInt(display.getInputFromUser());
        MenuOption menuOption;
        switch (option) {
            case 1:
                menuOption = new ListBooksMenuOption(biblioteca, display);
                break;
            case 2:
                menuOption = new QuitMenuOption();
                break;
            default:
                menuOption = new InvalidMenuOption(display);
        }
        menu.handleSelectedMenuOption(menuOption);
    }
}
