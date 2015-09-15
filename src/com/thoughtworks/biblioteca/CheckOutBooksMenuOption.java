package com.thoughtworks.biblioteca;

//Get bookname from user and does checkout operation
public class CheckOutBooksMenuOption implements MenuOption{
    private Biblioteca libraryBookData;
    private ConsoleDisplay consoleDisplay;
    private UserInfo userInfo;

    public CheckOutBooksMenuOption(Biblioteca libraryBookData, ConsoleDisplay consoleDisplay, UserInfo userInfo) {
        this.libraryBookData = libraryBookData;
        this.consoleDisplay = consoleDisplay;
        this.userInfo = userInfo;
    }
    @Override
    public void performOperation() {
        String bookName = consoleDisplay.getInputFromUser();
        Book bookToBeSearched = new Book(bookName, null, 0);
        int index = libraryBookData.getIndexOfLibraryItemInAvailableList(bookToBeSearched);

        if(index != -1) {
            LibraryItem libraryItem = libraryBookData.removeLibraryItemFromAvailableList(index);
            Book book = (Book) libraryItem;
            CheckedOutBook checkedOutBook = new CheckedOutBook(book, userInfo);
            libraryBookData.addLibraryItemToCheckedOutList(checkedOutBook);
            consoleDisplay.printMessage("Thank you! Enjoy the book\n");
        }
        else {
            consoleDisplay.printMessage("That book is not available\n");
        }
    }
}
