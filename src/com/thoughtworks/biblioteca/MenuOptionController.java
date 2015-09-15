package com.thoughtworks.biblioteca;

//based on the option delegates the functionality
public class MenuOptionController {
    private Menu menu;
    private Biblioteca bookLibraryData;
    private Biblioteca movieLibraryData;
    private Display display;

    public MenuOptionController(Menu menu, Biblioteca bookLibraryData, Biblioteca movieLibraryData, Display display) {
        this.menu = menu;
        this.bookLibraryData = bookLibraryData;
        this.movieLibraryData = movieLibraryData;
        this.display = display;
    }

    public void displayMenuOption() {
        display.printMessage(menu.getMenuOptions());
    }

    public void handleMenuOption(String option) {
        MenuOption menuOption = getMenuOption(option);
        menu.handleSelectedMenuOption(menuOption);
    }

    public MenuOption getMenuOption(String option) {
        switch (option) {
            case "1":
                return new ListLibraryItemMenuOption(new BookView(bookLibraryData), display);
            case "2":
                return new QuitMenuOption();
            case "3":
                return new CheckoutMenuOption(bookLibraryData, display);
            case "4":
                return new ReturnBookOption(bookLibraryData, display);
            case "5":
                return new ListLibraryItemMenuOption(new MovieView(movieLibraryData), display);
            default:
                return new InvalidMenuOption(display);
        }
    }
}
