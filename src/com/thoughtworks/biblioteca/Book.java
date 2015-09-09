package com.thoughtworks.biblioteca;

//containsBookInAvailableList the book details
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

    @Override
    public boolean equals(Object that) {
        if(that == this)
            return true;
        if (that == null || that.getClass() != getClass())
            return false;
        Book thatBookName = (Book) that;
        return bookName.equals(thatBookName.bookName);
    }

    @Override
    public int hashCode() {
        return bookName.hashCode();
    }
}
