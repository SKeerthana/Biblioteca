package com.thoughtworks.biblioteca.options;

import com.thoughtworks.biblioteca.view.ConsoleDisplay;
import com.thoughtworks.biblioteca.user.User;

public class LogoutMenuOption implements MenuOption {
    private ConsoleDisplay consoleDisplay;
    private User user;

    public LogoutMenuOption(ConsoleDisplay consoleDisplay, User user) {
        this.consoleDisplay = consoleDisplay;
        this.user = user;
    }

    @Override
    public void performOperation() {
        if(!user.isAuthenticatedUser())
            consoleDisplay.printMessage("Logout successful\n");
        else
            consoleDisplay.printMessage("Logout unsuccessful\n");
    }
}
