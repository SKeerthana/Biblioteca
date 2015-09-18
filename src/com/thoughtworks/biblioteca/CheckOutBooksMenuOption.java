package com.thoughtworks.biblioteca;

//Get bookname from user and does checkout operation
public class CheckOutBooksMenuOption implements MenuOption{
    private Library libraryBookData;
    private ConsoleDisplay consoleDisplay;
    private User user;
    private final String UNKNOWN_AUTHOR = null;
    private final int UNKNOWN_YEAR_PUBLISHED = 0;

    public CheckOutBooksMenuOption(Library libraryBookData, ConsoleDisplay consoleDisplay, User user) {
        this.libraryBookData = libraryBookData;
        this.consoleDisplay = consoleDisplay;
        this.user = user;
    }
    @Override
    public void performOperation() {
        String bookName = consoleDisplay.getInputFromUser();
        Book bookToBeSearched = new Book(bookName, UNKNOWN_AUTHOR, UNKNOWN_YEAR_PUBLISHED);
        int index = libraryBookData.getIndexOfLibraryItemInAvailableList(bookToBeSearched);

        if(index != -1) {
            LibraryItem libraryItem = libraryBookData.removeLibraryItemFromAvailableList(index);
            Book book = (Book) libraryItem;
            CheckedOutBook checkedOutBook = new CheckedOutBook(book, user);
            libraryBookData.addLibraryItemToCheckedOutList(checkedOutBook);
            consoleDisplay.printMessage("Thank you! Enjoy the book\n");
        }
        else {
            consoleDisplay.printMessage("That book is not available\n");
        }
    }
}
