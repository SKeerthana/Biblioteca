package com.thoughtworks.biblioteca;

import java.util.List;

public class BookView implements LibraryView{
    private Biblioteca bookLibraryData;

    public BookView(Biblioteca bookLibraryData) {
        this.bookLibraryData = bookLibraryData;
    }

    public String getFormattedListOfItems() {
        List<LibraryItem> availableBooks = bookLibraryData.getAvailableItems();
        String booksHeader = "=====================================================================================\n";
        booksHeader += getItemDetailsHeader(availableBooks.get(0));
        booksHeader += "=====================================================================================\n";
        String bookDetails = getItemDetails(availableBooks);
        String bookFooter = "=====================================================================================\n";
        return booksHeader + bookDetails + bookFooter;
    }

    private String getItemDetails(List<LibraryItem> books) {
        String bookDetails = "";
        for (LibraryItem bookItem : books) {
            Book book = (Book) bookItem;
            bookDetails += String.format("%-50s %-25s %-15s\n", book.getBookName(), book.getAuthor(), book.getYearPublished());
        }
        return bookDetails;
    }

    private String getItemDetailsHeader(LibraryItem book) {
        return String.format("%-50s %-25s %-15s\n", book.getHeaderDetails());
    }
}
