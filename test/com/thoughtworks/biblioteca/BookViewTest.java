package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookViewTest {
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
    }};
    Book book2 = new Book("Good will hunting", "some person", 1998);
    User user = new User("ABC", "ABC", "", "abc@gmail.com", "9944172304", new LoggedInUserRole());
    CheckedOutBook checkedOutBook = new CheckedOutBook(book2, user);
    ArrayList<LibraryItem> checkedOutBooks = new ArrayList<LibraryItem>() {{
        add(checkedOutBook);
    }};
    Library bibilioteca = new Library(listOfBooks, checkedOutBooks);

    @Test
    public void shouldDisplayListOfAvailableBooks() {
        BookView bookView = new BookView(bibilioteca);
        String header = "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s\n", "BOOK NAME", "AUTHOR", "YEAR");
        header += "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s\n", "My experiments with Truth", "M.K.Gandhi", "1942");
        header += "=====================================================================================\n";
        assertEquals(header, bookView.getFormattedListOfItems());
    }

    @Test
    public void shouldDisplayListOfCheckedOutBooks() {
        BookView bookView = new BookView(bibilioteca);
        String header = "==========================================================================================================================\n";
        header += String.format("%-50s %-25s %-15s %-25s\n", "BOOK NAME", "AUTHOR", "YEAR", "LIBRARY NUMBER");
        header += "==========================================================================================================================\n";
        header += String.format("%-50s %-25s %-15s %-25s\n", "Good will hunting", "some person", "1998", "ABC");
        header += "==========================================================================================================================\n";
        assertEquals(header, bookView.getFormattedListOfCheckedOutItems());
    }

    @Test
    public void shouldDisplayNoBooksAvailableWhenAvailableBookListIsEmpty() {
        Library bibilioteca = new Library(new ArrayList<LibraryItem>(), checkedOutBooks);
        BookView bookView = new BookView(bibilioteca);

        assertEquals("No books to display\n", bookView.getFormattedListOfItems());
    }

    @Test
    public void shouldDisplayNoBooksAvailableWhenCheckedOutBookListIsEmpty() {
        Library bibilioteca = new Library(listOfBooks, new ArrayList<LibraryItem>());
        BookView bookView = new BookView(bibilioteca);

        assertEquals("No books to display\n", bookView.getFormattedListOfCheckedOutItems());
    }
}
