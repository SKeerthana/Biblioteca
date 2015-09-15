package com.thoughtworks.biblioteca;

//Get bookname from user to return book to the library
public class ReturnBookOption implements MenuOption {
    private Biblioteca biblioteca;
    private Display display;

    public ReturnBookOption(Biblioteca biblioteca, Display display) {
        this.biblioteca = biblioteca;
        this.display = display;
    }

    @Override
    public void performOperation() {
        String bookName = display.getInputFromUser();
        Book bookToBeReturned = new Book(bookName, null, 0);
        if(biblioteca.containsLibraryItemInCheckedOutList(bookToBeReturned)) {
            biblioteca.returnLibraryItem(bookToBeReturned);
            display.printMessage("Thank you for returning the book.\n");
        }
        else
        {
            display.printMessage("That is not a valid book to return.\n");
        }
    }
}
