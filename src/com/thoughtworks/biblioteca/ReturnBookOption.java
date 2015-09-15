package com.thoughtworks.biblioteca;

//Get bookname from user to return book to the library
public class ReturnBookOption implements MenuOption {
    private Biblioteca libraryBookData;
    private ConsoleDisplay consoleDisplay;
    private UserInfo userInfo;

    public ReturnBookOption(Biblioteca libraryBookData, ConsoleDisplay consoleDisplay, UserInfo userInfo) {
        this.libraryBookData = libraryBookData;
        this.consoleDisplay = consoleDisplay;
        this.userInfo = userInfo;
    }

    @Override
    public void performOperation() {
        String bookName = consoleDisplay.getInputFromUser();
        Book bookToBeReturned = new Book(bookName, null, 0);
        int index = libraryBookData.getIndexOfLibraryItemInCheckedOutItems(bookToBeReturned);

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
