package com.thoughtworks.biblioteca;

import java.util.List;

public class BookView implements LibraryView {
    private Biblioteca bookLibraryData;

    public BookView(Biblioteca bookLibraryData) {
        this.bookLibraryData = bookLibraryData;
    }

    public String getFormattedListOfItems() {
        List<LibraryItem> availableBooks = bookLibraryData.getAvailableItems();
        if (availableBooks.size() > 0) {
            String booksHeader = "=====================================================================================\n";
            booksHeader += getAvailableItemDetailsHeader(availableBooks.get(0));
            booksHeader += "=====================================================================================\n";
            String bookDetails = getAvailableItemDetails(availableBooks);
            String bookFooter = "=====================================================================================\n";
            return booksHeader + bookDetails + bookFooter;
        }
        return "No books to display\n";
    }

    @Override
    public String getFormattedListOfCheckedOutItems() {
        List<LibraryItem> checkedOutItems = bookLibraryData.getCheckedOutItems();
        if(checkedOutItems.size() > 0) {
            String booksHeader = "==========================================================================================================================\n";
            booksHeader += getCheckedOutItemDetailsHeader(checkedOutItems.get(0));
            booksHeader += "==========================================================================================================================\n";
            String bookDetails = getCheckOutItemDetails(checkedOutItems);
            String bookFooter = "==========================================================================================================================\n";
            return booksHeader + bookDetails + bookFooter;
        }
        return "No books to display\n";
    }

    private String getCheckOutItemDetails(List<LibraryItem> checkedOutItems) {
        String bookDetails = "";
        for (LibraryItem bookItem : checkedOutItems) {
            CheckedOutBook checkedOutBook = (CheckedOutBook) bookItem;
            bookDetails += String.format("%-50s %-25s %-15s %-25s\n", checkedOutBook.getBookName(), checkedOutBook.getAuthor(), checkedOutBook.getYearPublished(), checkedOutBook.getUser().getLibraryNumber());
        }
        return bookDetails;
    }

    private String getCheckedOutItemDetailsHeader(LibraryItem checkedOutBook) {
        return String.format("%-50s %-25s %-15s %-25s\n", checkedOutBook.getHeaderDetails());
    }

    private String getAvailableItemDetails(List<LibraryItem> books) {
        String bookDetails = "";
        for (LibraryItem bookItem : books) {
            Book book = (Book) bookItem;
            bookDetails += String.format("%-50s %-25s %-15s\n", book.getBookName(), book.getAuthor(), book.getYearPublished());
        }
        return bookDetails;
    }

    private String getAvailableItemDetailsHeader(LibraryItem book) {
        return String.format("%-50s %-25s %-15s\n", book.getHeaderDetails());
    }
}
