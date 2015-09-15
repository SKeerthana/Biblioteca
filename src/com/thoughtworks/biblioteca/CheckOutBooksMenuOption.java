package com.thoughtworks.biblioteca;

//Get bookname from user and does checkout operation
public class CheckOutBooksMenuOption implements MenuOption{
    private Biblioteca libraryBookData;
    private ConsoleDisplay consoleDisplay;

    public CheckOutBooksMenuOption(Biblioteca libraryBookData, ConsoleDisplay consoleDisplay) {
        this.libraryBookData = libraryBookData;
        this.consoleDisplay = consoleDisplay;
    }
    @Override
    public void performOperation() {
        String bookName = consoleDisplay.getInputFromUser();
        Book bookToBeSearched = new Book(bookName, null, 0);
        if(libraryBookData.containsLibraryItemInAvailableList(bookToBeSearched)) {
            libraryBookData.checkOutLibraryItem(bookToBeSearched);
            consoleDisplay.printMessage("Thank you! Enjoy the book\n");
        }
        else {
            consoleDisplay.printMessage("That book is not available\n");
        }
    }
}
