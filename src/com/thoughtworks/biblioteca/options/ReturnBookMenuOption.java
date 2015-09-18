package com.thoughtworks.biblioteca.options;

import com.thoughtworks.biblioteca.model.*;
import com.thoughtworks.biblioteca.view.*;
import com.thoughtworks.biblioteca.user.*;

//Get bookname from user to return book to the library
public class ReturnBookMenuOption implements MenuOption {
    private Library libraryBookData;
    private ConsoleDisplay consoleDisplay;
    private User user;
    private final String UNKNOWN_AUTHOR = null;
    private final int UNKNOWN_YEAR_PUBLISHED = 0;

    public ReturnBookMenuOption(Library libraryBookData, ConsoleDisplay consoleDisplay, User user) {
        this.libraryBookData = libraryBookData;
        this.consoleDisplay = consoleDisplay;
        this.user = user;
    }

    @Override
    public void performOperation() {
        String bookName = consoleDisplay.getInputFromUser();
        Book bookToBeReturned = new Book(bookName, UNKNOWN_AUTHOR, UNKNOWN_YEAR_PUBLISHED);
        CheckedOutBook checkedOutBook = new CheckedOutBook(bookToBeReturned, user);
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
