package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//Bibilioteca contains the list of books
public class Biblioteca {

    private ArrayList<Book> books;

    public Biblioteca(ArrayList<Book> books) {
        this.books = books;
    }

    public boolean contains(Book bookName) {
        if (books.contains(bookName))
            return true;
        return false;
    }

    public void remove(Book bookName) {
        books.remove(bookName);
    }

    public String getListOfBooks() {
        String listOfBooksString = "";
        for (Book book : books) {
            listOfBooksString += book.getBookDetails();
        }
        return listOfBooksString;
    }
}
