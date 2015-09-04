package com.thoughtworks.biblioteca;

import java.util.ArrayList;
//Bibilioteca contains the list of books
public class Biblioteca {

    private ArrayList<Book> books;

    public Biblioteca(ArrayList<Book> books) {
        this.books = books;
    }

    public String getListOfBooks() {
        String listOfBooksString = "";
        for (Book book : books) {
            listOfBooksString += book.getBookDetails();
        }
        return listOfBooksString;
    }
}
