package com.thoughtworks.biblioteca;

public class LoginMenuOption implements MenuOption {
    private ConsoleDisplay consoleDisplay;
    private UserAuthenticator userAuthenticator;

    public LoginMenuOption(ConsoleDisplay consoleDisplay, UserAuthenticator userAuthenticator) {
        this.consoleDisplay = consoleDisplay;
        this.userAuthenticator = userAuthenticator;
    }

    @Override
    public void performOperation() {
        User currentUser = userAuthenticator.loginUser(consoleDisplay);
        if(currentUser.isAuthenticatedUser())
            consoleDisplay.printMessage("Login Successful\n");
    }
}
