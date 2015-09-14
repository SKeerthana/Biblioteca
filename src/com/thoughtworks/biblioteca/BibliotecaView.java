package com.thoughtworks.biblioteca;

import java.util.Arrays;
import java.util.List;

public class BibliotecaView {
    private Biblioteca biblioteca;

    public BibliotecaView(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getFormattedListOfBooks() {
        List<Book> availableBooks = biblioteca.getAvailableBooks();
        String booksHeader = "=====================================================================================\n";
        booksHeader += getBookDetailsHeader(availableBooks.get(0));
        booksHeader += "=====================================================================================\n";
        String bookDetails = getBookDetails(availableBooks);
        String bookFooter = "=====================================================================================\n";
        return booksHeader + bookDetails + bookFooter;
    }

    private String getBookDetails(List<Book> books) {
        String bookDetails = "";
        for (Book book : books)
            bookDetails += String.format("%-50s %-25s %-15s\n", book.getBookName(), book.getAuthor(), book.getYearPublished());
        return bookDetails;
    }

    private String getBookDetailsHeader(Book book) {
        return String.format("%-50s %-25s %-15s\n", book.getBookHeaders());
    }
}
