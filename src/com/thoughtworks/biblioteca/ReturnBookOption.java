package com.thoughtworks.biblioteca;

//Get bookname from user to return book to the library
public class ReturnBookOption implements MenuOption {
    private Biblioteca libraryBookData;
    private ConsoleDisplay consoleDisplay;
    private User user;

    public ReturnBookOption(Biblioteca libraryBookData, ConsoleDisplay consoleDisplay, User user) {
        this.libraryBookData = libraryBookData;
        this.consoleDisplay = consoleDisplay;
        this.user = user;
    }

    @Override
    public void performOperation() {
        String bookName = consoleDisplay.getInputFromUser();
        Book bookToBeReturned = new Book(bookName, null, 0);
        CheckedOutBook checkedOutBook = new CheckedOutBook(bookToBeReturned, null);
        int index = libraryBookData.getIndexOfLibraryItemInCheckedOutItems(checkedOutBook);

        if (index != -1) {
            LibraryItem libraryItem = libraryBookData.removeLibraryItemFromCheckedOutList(index);
            Book book = (Book) libraryItem;
            libraryBookData.addLibraryItemToAvailableList(book);
            consoleDisplay.printMessage("Thank you for returning the book.\n");
        } else {
            consoleDisplay.printMessage("That is not a valid book to return.\n");
        }
    }
}
