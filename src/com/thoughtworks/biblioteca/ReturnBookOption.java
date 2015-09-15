package com.thoughtworks.biblioteca;

//Get bookname from user to return book to the library
public class ReturnBookOption implements MenuOption {
    private Biblioteca biblioteca;
    private ConsoleDisplay consoleDisplay;

    public ReturnBookOption(Biblioteca biblioteca, ConsoleDisplay consoleDisplay) {
        this.biblioteca = biblioteca;
        this.consoleDisplay = consoleDisplay;
    }

    @Override
    public void performOperation() {
        String bookName = consoleDisplay.getInputFromUser();
        Book bookToBeReturned = new Book(bookName, null, 0);
        if(biblioteca.containsLibraryItemInCheckedOutList(bookToBeReturned)) {
            biblioteca.returnLibraryItem(bookToBeReturned);
            consoleDisplay.printMessage("Thank you for returning the book.\n");
        }
        else
        {
            consoleDisplay.printMessage("That is not a valid book to return.\n");
        }
    }
}
