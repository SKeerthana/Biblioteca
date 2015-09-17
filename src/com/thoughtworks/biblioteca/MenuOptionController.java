package com.thoughtworks.biblioteca;

//based on the option delegates the functionality
public class MenuOptionController {
    private Menu menu;
    private Biblioteca bookLibraryData;
    private Biblioteca movieLibraryData;
    private ConsoleDisplay consoleDisplay;
    private UserAuthenticator userAuthenticator;
    private User currentUser;

    public MenuOptionController(Menu menu, Biblioteca bookLibraryData, Biblioteca movieLibraryData, ConsoleDisplay consoleDisplay, UserAuthenticator userAuthenticator, User currentUser) {
        this.menu = menu;
        this.bookLibraryData = bookLibraryData;
        this.movieLibraryData = movieLibraryData;
        this.consoleDisplay = consoleDisplay;
        this.userAuthenticator = userAuthenticator;
        this.currentUser = currentUser;
    }

    public void displayMenuOption() {
        consoleDisplay.printMessage(menu.getMenuOptionsToDisplay(currentUser));
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
                if (!currentUser.isAuthenticatedUser())
                    currentUser = userAuthenticator.loginUser(consoleDisplay);

                if (currentUser.isAuthenticatedUser())
                    return new CheckOutBooksMenuOption(bookLibraryData, consoleDisplay, currentUser);
                break;
            case "4":
                if (currentUser.isAuthenticatedUser())
                    return new ReturnBookOption(bookLibraryData, consoleDisplay, currentUser);
                break;
            case "5":
                return new ListLibraryItemMenuOption(new MovieView(movieLibraryData), consoleDisplay);
            case "6":
                return new CheckOutMoviesMenuOption(movieLibraryData, consoleDisplay);
            case "7":
                return new LoginMenuOption(consoleDisplay, userAuthenticator);
        }
        return new InvalidMenuOption(consoleDisplay);
    }
}
