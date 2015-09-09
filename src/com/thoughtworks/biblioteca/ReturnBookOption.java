package com.thoughtworks.biblioteca;

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
        biblioteca.returnBook(bookToBeReturned);
    }
}
