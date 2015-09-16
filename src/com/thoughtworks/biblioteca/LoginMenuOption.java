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
        consoleDisplay.printMessage("Enter Library Number : ");
        String libraryNumber = consoleDisplay.getInputFromUser();
        consoleDisplay.printMessage("Enter Password : ");
        String password = consoleDisplay.getInputFromUser();
        if (userAuthenticator.authenticate(libraryNumber, password))
            consoleDisplay.printMessage("Login Successful\n");
    }
}
