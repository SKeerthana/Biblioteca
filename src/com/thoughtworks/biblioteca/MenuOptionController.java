package com.thoughtworks.biblioteca;

//based on the option delegates the functionality
public class MenuOptionController {
    private Menu menu;
    private Biblioteca bookLibraryData;
    private Biblioteca movieLibraryData;
    private ConsoleDisplay consoleDisplay;
    private UserManager userManager;
    private UserInfo userInfo;

    public MenuOptionController(Menu menu, Biblioteca bookLibraryData, Biblioteca movieLibraryData, ConsoleDisplay consoleDisplay, UserManager userManager) {
        this.menu = menu;
        this.bookLibraryData = bookLibraryData;
        this.movieLibraryData = movieLibraryData;
        this.consoleDisplay = consoleDisplay;
        this.userManager = userManager;
        this.userInfo = new UserInfo("lib-0001", "name", "abc", "abc@gmail.com", Role.GUEST);
    }

    public void displayMenuOption() {
        consoleDisplay.printMessage(menu.getMenuOptions(userInfo));
    }

    public void handleMenuOption(String option) {
        MenuOption menuOption = getMenuOption(option);
        menu.handleSelectedMenuOption(menuOption);
    }

    public MenuOption getMenuOption(String option) {
        switch (option) {
            case "1":
                return new ListLibraryItemMenuOption(new BookView(bookLibraryData), consoleDisplay);
            case "2":
                return new QuitMenuOption();
            case "3":
                return new CheckOutBooksMenuOption(bookLibraryData, consoleDisplay, new UserInfo("", "", "", "", Role.ADMIN));
            case "4":
                return new ReturnBookOption(bookLibraryData, consoleDisplay, new UserInfo("", "", "", "", Role.ADMIN));
            case "5":
                return new ListLibraryItemMenuOption(new MovieView(movieLibraryData), consoleDisplay);
            case "6":
                return new CheckOutMoviesMenuOption(movieLibraryData, consoleDisplay);
            case "7":
                return new LoginMenuOption(consoleDisplay, userManager);
            default:
                return new InvalidMenuOption(consoleDisplay);
        }
    }
}
