package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldReturnTheBookDetails() {
        Book book = new Book("Star Wars");
        assertEquals("Star Wars", book.getBookDetails());
    }
}
