package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//Bibilioteca contains the list of available and checked out books
public class Biblioteca {

    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedoutBooks;

    public Biblioteca(ArrayList<Book> availableBooks, ArrayList<Book> checkedoutBooks) {
        this.availableBooks = availableBooks;
        this.checkedoutBooks = checkedoutBooks;
    }

    public boolean containsBookInAvailableList(Book bookName) {
        if (availableBooks.contains(bookName))
            return true;
        return false;
    }

    public boolean containsBookInCheckedOutList(Book bookName) {
        if (checkedoutBooks.contains(bookName))
            return true;
        return false;
    }

    public void checkOutBook(Book bookName) {
        int index = availableBooks.indexOf(bookName);
        checkedoutBooks.add(availableBooks.get(index));
        availableBooks.remove(bookName);
    }

    public String getListOfBooks() {
        String listOfBooksString = "";
        for (Book book : availableBooks) {
            listOfBooksString += book.getBookDetails();
        }
        return listOfBooksString;
    }

    public void returnBook(Book bookToBeReturned) {
        int index = checkedoutBooks.indexOf(bookToBeReturned);
        availableBooks.add(checkedoutBooks.get(index));
        checkedoutBooks.remove(bookToBeReturned);
    }
}
