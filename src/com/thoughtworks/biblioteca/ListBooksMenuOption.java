package com.thoughtworks.biblioteca;

//displays the list of books
public class ListBooksMenuOption implements MenuOption {
    private LibraryView bookView;
    private Display display;

    public ListBooksMenuOption(LibraryView bookView, Display display) {
        this.bookView = bookView;
        this.display = display;
    }

    @Override
    public void performOperation() {
        display.printMessage(bookView.getFormattedListOfItems());
    }
}
