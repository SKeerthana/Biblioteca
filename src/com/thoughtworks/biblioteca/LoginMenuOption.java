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
        if(userManager.login("", ""))
            consoleDisplay.printMessage("Login Successful");
    }
}
