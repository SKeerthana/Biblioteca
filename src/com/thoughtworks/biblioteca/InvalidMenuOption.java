package com.thoughtworks.biblioteca;

//generates a message for invalid menu option
public class InvalidMenuOption implements MenuOption {

    private Display display;

    public InvalidMenuOption(Display display) {
        this.display = display;
    }

    @Override
    public void performOperation() {
        display.printMessage("Select a valid option!\n");
    }
}
