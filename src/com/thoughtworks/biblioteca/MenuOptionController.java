package com.thoughtworks.biblioteca;

//based on the option delegates the functionality
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

    public void handleMenuOption(String option) {
        MenuOption menuOption = getMenuOption(option);
        menu.handleSelectedMenuOption(menuOption);
    }

    private MenuOption getMenuOption(String option) {
        switch (option) {
            case "1":
                return new ListBooksMenuOption(biblioteca, display);
            case "2":
                return new QuitMenuOption();
            case "3":
                return new CheckoutMenuOption(biblioteca, display);
            case "4":
                return new ReturnBookOption(biblioteca, display);
            default:
                return new InvalidMenuOption(display);
        }
    }
}
