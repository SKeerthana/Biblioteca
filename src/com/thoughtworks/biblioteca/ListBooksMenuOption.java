package com.thoughtworks.biblioteca;

public class ListBooksMenuOption implements MenuOption {
    private Biblioteca biblioteca;
    private Display display;

    public ListBooksMenuOption(Biblioteca biblioteca, Display display) {
        this.biblioteca = biblioteca;
        this.display = display;
    }

    @Override
    public void performOperation() {
        display.printMessage(biblioteca.getListOfBooks());
    }

    @Override
    public boolean equals(Object object) {
        return true;
    }
}
