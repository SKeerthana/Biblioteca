package com.thoughtworks.biblioteca;

//contains the book details
public class Book {
    private String bookName;
    private String author;
    private int yearPublished;

    public Book(String bookName, String author, int yearPublished) {
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public String getBookDetails() {
        return bookName + "\t" + author + "\t" + yearPublished + "\n";
    }

}
