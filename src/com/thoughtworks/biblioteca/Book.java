package com.thoughtworks.biblioteca;
//contains the book details
public class Book {
    private String bookName;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDetails() {
        return bookName;
    }
}
