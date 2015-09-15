package com.thoughtworks.biblioteca;

//Get bookname from user and does checkout operation
public class CheckOutBooksMenuOption implements MenuOption{
    private Biblioteca libraryBookData;
    private Display display;

    public CheckOutBooksMenuOption(Biblioteca libraryBookData, Display display) {
        this.libraryBookData = libraryBookData;
        this.display = display;
    }
    @Override
    public void performOperation() {
        String bookName = display.getInputFromUser();
        Book bookToBeSearched = new Book(bookName, null, 0);
        if(libraryBookData.containsBookInAvailableList(bookToBeSearched)) {
            libraryBookData.checkOutBook(bookToBeSearched);
            display.printMessage("Thank you! Enjoy the book\n");
        }
        else {
            display.printMessage("That book is not available\n");
        }
    }
}
