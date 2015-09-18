package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
        add(book2);
    }};
    Library bibilioteca = new Library(listOfBooks, new ArrayList<LibraryItem>());

    @Test
    public void shouldReturnIndexOfBookInAvailableList() {
        assertEquals(0, bibilioteca.getIndexOfLibraryItemInAvailableList(new Book("My experiments with Truth", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldReturnNegativeIndexIfBookDoesNotExistsInAvailableList() {
        assertEquals(-1, bibilioteca.getIndexOfLibraryItemInAvailableList(new Book("My experiments", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldReturnIndexOfBookInCheckOutList() {
        Library bibilioteca = new Library(new ArrayList<LibraryItem>(), listOfBooks);

        assertEquals(0, bibilioteca.getIndexOfLibraryItemInCheckedOutItems(new Book("My experiments with Truth", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldReturnNegativeIndexIfBookDoesNotExistsInCheckedOutList() {
        Library bibilioteca = new Library(new ArrayList<LibraryItem>(), listOfBooks);

        assertEquals(-1, bibilioteca.getIndexOfLibraryItemInAvailableList(new Book("My experiments", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldRemoveBookFromAvailableList() {
        bibilioteca.removeLibraryItemFromAvailableList(0);

        assertEquals(-1, bibilioteca.getIndexOfLibraryItemInAvailableList(new Book("My experiments", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldAddBookToCheckoutList() {
        Book bookToAdd = new Book("My experiments", "M.K.Gandhi", 1942);

        bibilioteca.addLibraryItemToCheckedOutList(bookToAdd);

        assertEquals(0, bibilioteca.getIndexOfLibraryItemInCheckedOutItems(new Book("My experiments", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldRemoveBookFromCheckoutListWhenItIsReturned() {
        Library bibilioteca = new Library(new ArrayList<LibraryItem>(), listOfBooks);
        bibilioteca.removeLibraryItemFromCheckedOutList(0);
        assertEquals(-1, bibilioteca.getIndexOfLibraryItemInAvailableList(new Book("My experiments", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldAddBookToAvailableListWhenBookIsReturned() {
        Book bookToAdd = new Book("My experiments", "M.K.Gandhi", 1942);

        bibilioteca.addLibraryItemToAvailableList(bookToAdd);

        assertEquals(2, bibilioteca.getIndexOfLibraryItemInAvailableList(new Book("My experiments", "M.K.Gandhi", 1942)));
    }
}
