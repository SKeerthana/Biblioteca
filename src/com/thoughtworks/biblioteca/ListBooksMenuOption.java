package com.thoughtworks.biblioteca;

//displays the list of books
public class ListBooksMenuOption implements MenuOption {
    private BibliotecaView bibliotecaView;
    private Display display;

    public ListBooksMenuOption(BibliotecaView bibliotecaView, Display display) {
        this.bibliotecaView = bibliotecaView;
        this.display = display;
    }

    @Override
    public void performOperation() {
        display.printMessage(bibliotecaView.getFormattedListOfBooks());
    }
}
