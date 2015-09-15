package com.thoughtworks.biblioteca;

//displays the list of books
public class ListLibraryItemMenuOption implements MenuOption {
    private LibraryView libraryView;
    private ConsoleDisplay consoleDisplay;

    public ListLibraryItemMenuOption(LibraryView libraryView, ConsoleDisplay consoleDisplay) {
        this.libraryView = libraryView;
        this.consoleDisplay = consoleDisplay;
    }

    @Override
    public void performOperation() {
        consoleDisplay.printMessage(libraryView.getFormattedListOfItems());
    }
}
