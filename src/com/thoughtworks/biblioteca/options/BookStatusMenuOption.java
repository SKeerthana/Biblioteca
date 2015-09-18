package com.thoughtworks.biblioteca.options;

import com.thoughtworks.biblioteca.view.ConsoleDisplay;
import com.thoughtworks.biblioteca.view.LibraryView;

public class BookStatusMenuOption implements MenuOption {
    private LibraryView libraryView;
    private ConsoleDisplay consoleDisplay;

    public BookStatusMenuOption(LibraryView libraryView, ConsoleDisplay consoleDisplay) {
        this.libraryView = libraryView;
        this.consoleDisplay = consoleDisplay;
    }

    @Override
    public void performOperation() {
        consoleDisplay.printMessage(libraryView.getFormattedListOfCheckedOutItems());
    }
}
