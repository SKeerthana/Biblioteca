package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void shouldReturnListOfBooks() {
        Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Biblioteca bibilioteca = new Biblioteca(listOfBooks);
        assertEquals("My experiments with Truth\t" + "M.K.Gandhi\t" + "1942\n"
                + "Harry Potter and the Chamber of Secrets\t" + "J. K. Rowling\t" + "1998\n", bibilioteca.getListOfBooks());
    }

}
