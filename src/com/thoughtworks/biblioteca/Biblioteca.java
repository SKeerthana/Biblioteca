package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Book> books;

    public Biblioteca(ArrayList<Book> books) {
        this.books = books;
    }

    public String getListOfBooks() {
        String listOfBooksString = "";
        for (Book book : books) {
            listOfBooksString += book.getBookDetails() + "\n";
        }
        return listOfBooksString;
    }
}
