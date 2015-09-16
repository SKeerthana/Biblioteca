package com.thoughtworks.biblioteca;

public class LoginMenuOption implements MenuOption {
    private ConsoleDisplay consoleDisplay;
    private UserManager userManager;

    public LoginMenuOption(ConsoleDisplay consoleDisplay, UserManager userManager) {
        this.consoleDisplay = consoleDisplay;
        this.userManager = userManager;
    }

    @Override
    public void performOperation() {
        consoleDisplay.printMessage("Enter Library Number : ");
        String libraryNumber = consoleDisplay.getInputFromUser();
        consoleDisplay.printMessage("Enter Password : ");
        String password = consoleDisplay.getInputFromUser();
        if(userManager.authenticate(libraryNumber, password))
            consoleDisplay.printMessage("Login Successful\n");
    }
}
