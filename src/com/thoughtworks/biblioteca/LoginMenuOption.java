package com.thoughtworks.biblioteca;

public class LoginMenuOption implements MenuOption {
    private ConsoleDisplay consoleDisplay;
    private User user;

    public LoginMenuOption(ConsoleDisplay consoleDisplay, User user) {
        this.consoleDisplay = consoleDisplay;
        this.user = user;
    }

    @Override
    public void performOperation() {
        if(user.isAuthenticatedUser())
            consoleDisplay.printMessage("Login successful\n");
        else
            consoleDisplay.printMessage("Login unsuccessful\n");
    }
}
