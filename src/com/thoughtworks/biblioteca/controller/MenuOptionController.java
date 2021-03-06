package com.thoughtworks.biblioteca.controller;

import com.thoughtworks.biblioteca.user.*;
import com.thoughtworks.biblioteca.options.*;
import com.thoughtworks.biblioteca.model.*;
import com.thoughtworks.biblioteca.view.*;

//based on the option delegates the functionality
public class MenuOptionController {
    private Menu menu;
    private Library bookLibraryData;
    private Library movieLibraryData;
    private ConsoleDisplay consoleDisplay;
    private UserAuthenticator userAuthenticator;
    private User currentUser;

    public MenuOptionController(Menu menu, Library bookLibraryData, Library movieLibraryData, ConsoleDisplay consoleDisplay, UserAuthenticator userAuthenticator, User currentUser) {
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
        int indexOfOption = Integer.valueOf(option).intValue() - 1;

        if (indexOfOption >= 0 && indexOfOption < currentUser.getMenuOptions().size())
            option = currentUser.getMenuOptions().get(indexOfOption);

        com.thoughtworks.biblioteca.options.MenuOption menuOption = getMenuOption(option);
        menu.handleSelectedMenuOption(menuOption);
    }

    private com.thoughtworks.biblioteca.options.MenuOption getMenuOption(String option) {
        switch (option) {
            case "List Books":
                return new ListLibraryItemMenuOption(new BookView(bookLibraryData), consoleDisplay);

            case "Quit":
                return new QuitMenuOption();

            case "CheckOut Book":
                if (!currentUser.isAuthenticatedUser())
                    currentUser = userAuthenticator.loginUser(consoleDisplay);

                if (currentUser.isAuthenticatedUser())
                    return new com.thoughtworks.biblioteca.options.CheckOutBooksMenuOption(bookLibraryData, consoleDisplay, currentUser);
                break;

            case "Return Book":
                if (!currentUser.isAuthenticatedUser())
                    currentUser = userAuthenticator.loginUser(consoleDisplay);

                if (currentUser.isAuthenticatedUser())
                    return new ReturnBookMenuOption(bookLibraryData, consoleDisplay, currentUser);
                break;

            case "List Movies":
                return new ListLibraryItemMenuOption(new MovieView(movieLibraryData), consoleDisplay);

            case "CheckOut Movie":
                return new CheckOutMoviesMenuOption(movieLibraryData, consoleDisplay);

            case "Log in":
                currentUser = userAuthenticator.loginUser(consoleDisplay);
                return new LoginMenuOption(consoleDisplay, currentUser);

            case "Log out":
                currentUser = userAuthenticator.logOut();
                return new LogoutMenuOption(consoleDisplay, currentUser);

            case "Book Status":
                return new BookStatusMenuOption(new BookView(bookLibraryData), consoleDisplay);

            case "User Information":
                return new UserInformationMenuOption(new UserView(currentUser), consoleDisplay);
        }
        return new InvalidMenuOption(consoleDisplay);
    }
}
