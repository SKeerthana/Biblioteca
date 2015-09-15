package com.thoughtworks.biblioteca;

//displays the list of books
public class ListLibraryItemMenuOption implements MenuOption {
    private LibraryView libraryView;
    private Display display;

    public ListLibraryItemMenuOption(LibraryView libraryView, Display display) {
        this.libraryView = libraryView;
        this.display = display;
    }

    @Override
    public void performOperation() {
        display.printMessage(libraryView.getFormattedListOfItems());
    }
}
