package com.thoughtworks.biblioteca;

//contains the details about the book
public class Book implements LibraryItem{
    protected String bookName;
    protected String author;
    protected int yearPublished;

    public Book(String bookName, String author, int yearPublished) {
        this.bookName = bookName;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    public Book(Book thatBook) {
        bookName = thatBook.bookName;
        author = thatBook.author;
        yearPublished = thatBook.yearPublished;
    }

    public String[] getHeaderDetails() {
        String[] bookHeaderInfo = new String[3];
        bookHeaderInfo[0] = "BOOK NAME";
        bookHeaderInfo[1] = "AUTHOR";
        bookHeaderInfo[2] = "YEAR";
        return bookHeaderInfo;
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

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
