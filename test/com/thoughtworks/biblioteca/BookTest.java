package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    @Test
    public void shouldReturnTheBookDetails() {
        Book book = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
        assertEquals("My experiments with Truth" + "\t" + "M.K.Gandhi" + "\t" + "1942" + "\n", book.getBookDetails());
    }
}
