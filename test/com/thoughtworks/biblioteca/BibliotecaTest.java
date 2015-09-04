package com.thoughtworks.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaTest {

    @Test
    public void shouldReturnListOfBooks() {
        Book book1 = new Book("Harry Potter and the Philosopher's Stone");
        Book book2 = new Book("Harry Potter and the Chamber of Secrets");
        ArrayList<Book> listOfBooks = new ArrayList<Book>();
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        Biblioteca bibilioteca = new Biblioteca(listOfBooks);
        assertEquals("Harry Potter and the Philosopher's Stone\n" + "Harry Potter and the Chamber of Secrets\n",bibilioteca.getListOfBooks());
    }

}
