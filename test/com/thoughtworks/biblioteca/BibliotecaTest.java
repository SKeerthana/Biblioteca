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
    Biblioteca bibilioteca = new Biblioteca(listOfBooks);

    @Test
    public void shouldReturnListOfBooks() {
        assertEquals("My experiments with Truth\t" + "M.K.Gandhi\t" + "1942\n"
                + "Harry Potter and the Chamber of Secrets\t" + "J. K. Rowling\t" + "1998\n", bibilioteca.getListOfBooks());
    }

    @Test
    public void shouldReturnTrueIfBookExistsInBookList() {
        assertTrue(bibilioteca.contains(new Book("My experiments with Truth", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldReturnFalseIfBookDoesNotExistsInBookList() {
        assertFalse(bibilioteca.contains(new Book("My experiments", "M.K.Gandhi", 1942)));
    }

    @Test
    public void shouldRemoveBookFromList() {
        Book bookToSearch = new Book("My experiments with Truth", null, 0);
        bibilioteca.checkOutBook(bookToSearch);
        assertFalse(bibilioteca.contains(bookToSearch));
    }

}
