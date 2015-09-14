package com.thoughtworks.biblioteca;

//displays the list of books
public class ListBooksMenuOption implements MenuOption {
    private Biblioteca biblioteca;
    private Display display;

    public ListBooksMenuOption(Biblioteca biblioteca, Display display) {
        this.biblioteca = biblioteca;
        this.display = display;
    }

    @Override
    public void performOperation() {
        display.printMessage("=====================================================================================");
        String header = String.format("%-50s %-25s %-15s", "BOOK NAME", "AUTHOR", "YEAR");
        display.printMessage("\n" + header);
        display.printMessage("=====================================================================================");
        display.printMessage(biblioteca.getListOfBooks());
        display.printMessage("=====================================================================================");

    }
}
