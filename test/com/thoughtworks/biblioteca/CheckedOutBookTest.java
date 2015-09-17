package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CheckedOutBookTest {

    @Test
    public void shouldReturnHeaderDetailsOfBookAndUserName() {
        String[] headerDetails = {"BOOK NAME", "AUTHOR", "YEAR", "LIBRARY NUMBER"};
        Book book = new Book("Abc", "Def", 1900);
        User user = new User("abc", "abc", "abc", "", new AdminRole());
        CheckedOutBook checkedOutBook = new CheckedOutBook(book, user);
        assertArrayEquals(headerDetails, checkedOutBook.getHeaderDetails());
    }
}
