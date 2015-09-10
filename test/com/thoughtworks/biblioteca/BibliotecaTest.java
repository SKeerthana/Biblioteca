package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BibliotecaTest {

    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<Book> listOfBooks = new ArrayList<Book>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<Book>());

    @Test
    public void shouldReturnListOfBooks() {
        assertEquals(String.format("%-50s %-25s %-15s\n", "My experiments with Truth", "M.K.Gandhi", "1942")
                + String.format("%-50s %-25s %-15s\n","Harry Potter and the Chamber of Secrets", "J. K. Rowling", "1998"), bibilioteca.getListOfBooks());
    }

    @Test
    public void shouldReturnTrueIfBookExistsInBookList() {
        assertTrue(bibilioteca.containsBookInAvailableList(new Book("My experiments with Truth", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldReturnFalseIfBookDoesNotExistsInBookList() {
        assertFalse(bibilioteca.containsBookInAvailableList(new Book("My experiments", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldRemoveBookFromAvailableList() {
        Book bookToSearch = new Book("My experiments with Truth", null, 0);
        bibilioteca.checkOutBook(bookToSearch);
        assertFalse(bibilioteca.containsBookInAvailableList(bookToSearch));
    }

    @Test
    public void shouldAddBookToCheckoutList() {
        Book bookToSearch = new Book("My experiments with Truth", null, 0);
        bibilioteca.checkOutBook(bookToSearch);
        assertTrue(bibilioteca.containsBookInCheckedOutList(bookToSearch));
    }

    @Test
    public void shouldRemoveBookFromCheckoutListWhenItIsReturned() {
        Book bookToReturn = new Book("My experiments with Truth", null, 0);
        Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<Book>(){{add(book1);}});
        bibilioteca.returnBook(bookToReturn);
        assertFalse(bibilioteca.containsBookInCheckedOutList(bookToReturn));
    }

    @Test
    public void shouldAddBookToAvailableListWhenBookIsReturned() {
        Book bookToReturn = new Book("My experiments with Truth", null, 0);
        Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<Book>(){{add(book1);}});
        bibilioteca.returnBook(bookToReturn);
        assertTrue(bibilioteca.containsBookInAvailableList(bookToReturn));
    }

}
