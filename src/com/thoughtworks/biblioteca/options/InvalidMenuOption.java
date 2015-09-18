package com.thoughtworks.biblioteca.options;

import com.thoughtworks.biblioteca.view.ConsoleDisplay;

//generates a message for invalid menu option
public class InvalidMenuOption implements MenuOption {

    private ConsoleDisplay consoleDisplay;

    public InvalidMenuOption(ConsoleDisplay consoleDisplay) {
        this.consoleDisplay = consoleDisplay;
    }

    @Override
    public void performOperation() {
        consoleDisplay.printMessage("Select a valid option!\n");
    }
}
