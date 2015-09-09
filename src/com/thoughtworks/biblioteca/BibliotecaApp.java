package com.thoughtworks.biblioteca;

import java.util.ArrayList;
//displays the welcome message and menu options
public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp bibliotecaApp = new BibliotecaApp();
        ArrayList<Book> listOfBooks = bibliotecaApp.generateListOfBooks();
        Biblioteca biblioteca = new Biblioteca(listOfBooks, new ArrayList<Book>());

        Display display = new Display(System.out, System.in);
        MenuOptionController menuOptionController = new MenuOptionController(new Menu(), biblioteca, display);

        display.printMessage("Welcome to Bibliotica\n");
        while (true) {
            menuOptionController.displayMenuOption();
            int option = display.getInputMenuOptionFromUser();
            menuOptionController.handleMenuOption(option);
        }

    }

    private ArrayList<Book> generateListOfBooks() {
        Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        return listOfBooks;
    }
}
