package com.thoughtworks.biblioteca;

import java.util.List;

public class BibliotecaView {
    private Biblioteca biblioteca;

    public BibliotecaView(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public String getFormattedListOfBooks() {
        List<LibraryItem> availableBooks = biblioteca.getAvailableItems();
        String booksHeader = "=====================================================================================\n";
        booksHeader += getBookDetailsHeader(availableBooks.get(0));
        booksHeader += "=====================================================================================\n";
        String bookDetails = getBookDetails(availableBooks);
        String bookFooter = "=====================================================================================\n";
        return booksHeader + bookDetails + bookFooter;
    }

    private String getBookDetails(List<LibraryItem> books) {
        String bookDetails = "";
        for (LibraryItem bookItem : books) {
            Book book = (Book) bookItem;
            bookDetails += String.format("%-50s %-25s %-15s\n", book.getBookName(), book.getAuthor(), book.getYearPublished());
        }
        return bookDetails;
    }

    private String getBookDetailsHeader(LibraryItem book) {
        return String.format("%-50s %-25s %-15s\n", book.getHeaderDetails());
    }
}
