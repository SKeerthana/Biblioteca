package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {

    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<LibraryItem>());

    @Test
    public void shouldReturnTrueIfBookExistsInBookList() {
        assertTrue(bibilioteca.containsLibraryItemInAvailableList(new Book("My experiments with Truth", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldReturnFalseIfBookDoesNotExistsInBookList() {
        assertFalse(bibilioteca.containsLibraryItemInAvailableList(new Book("My experiments", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldRemoveBookFromAvailableList() {
        Book bookToSearch = new Book("My experiments with Truth", null, 0);
        bibilioteca.checkOutLibraryItem(bookToSearch);
        assertFalse(bibilioteca.containsLibraryItemInAvailableList(bookToSearch));
    }

    @Test
    public void shouldAddBookToCheckoutList() {
        Book bookToSearch = new Book("My experiments with Truth", null, 0);
        bibilioteca.checkOutLibraryItem(bookToSearch);
        assertTrue(bibilioteca.containsLibraryItemInCheckedOutList(bookToSearch));
    }

    @Test
    public void shouldRemoveBookFromCheckoutListWhenItIsReturned() {
        Book bookToReturn = new Book("My experiments with Truth", null, 0);
        Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<LibraryItem>(){{add(book1);}});
        bibilioteca.returnLibraryItem(bookToReturn);
        assertFalse(bibilioteca.containsLibraryItemInCheckedOutList(bookToReturn));
    }

    @Test
    public void shouldAddBookToAvailableListWhenBookIsReturned() {
        Book bookToReturn = new Book("My experiments with Truth", null, 0);
        Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<LibraryItem>(){{add(book1);}});
        bibilioteca.returnLibraryItem(bookToReturn);
        assertTrue(bibilioteca.containsLibraryItemInAvailableList(bookToReturn));
    }

}
