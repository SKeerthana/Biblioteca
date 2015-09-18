package com.thoughtworks.biblioteca.options;

import com.thoughtworks.biblioteca.view.ConsoleDisplay;
import com.thoughtworks.biblioteca.view.UserView;

public class UserInformationMenuOption implements MenuOption {
    private UserView userView;
    private ConsoleDisplay consoleDisplay;

    public UserInformationMenuOption(UserView userView, ConsoleDisplay consoleDisplay) {
        this.userView = userView;
        this.consoleDisplay = consoleDisplay;
    }

    @Override
    public void performOperation() {
        consoleDisplay.printMessage(userView.getFormattedUserDetails());
    }
}
