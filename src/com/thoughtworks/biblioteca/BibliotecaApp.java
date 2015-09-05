package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//Manages the bibilioteca aaplication
public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Book> listOfBooks = generateListOfBooks();
        Display display = new Display(System.out, System.in);
        display.printMessage("Welcome to Bibliotica\n");

        Biblioteca biblioteca = new Biblioteca(listOfBooks);
        Menu menu = new Menu(biblioteca, display);
        int option;
        while (true) {
            display.printMessage(menu.getMenuOptions());
            option = display.getInputFromUser();
            menu.handleSelectedMenuOption(option);
        }

    }

    private static ArrayList<Book> generateListOfBooks() {
        Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        return listOfBooks;
    }
}
