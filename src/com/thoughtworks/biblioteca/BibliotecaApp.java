package com.thoughtworks.biblioteca;

import java.util.ArrayList;
//Manages the bibilioteca aaplication
public class BibliotecaApp {

    public static void main(String[] args) {
        ArrayList<Book> listOfBooks = generateListOfBooks();
        Display display = new Display(System.out);
        display.printMessage("Welcome to Bibliotica");

        Biblioteca biblioteca = new Biblioteca(listOfBooks);
        display.printMessage(biblioteca.getListOfBooks());

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
