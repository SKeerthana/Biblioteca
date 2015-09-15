package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CheckedOutBookTest {

    @Test
    public void shouldReturnHeaderDetailsOfBookAndUserName() {
        String[] headerDetails = {"BOOK NAME", "AUTHOR", "YEAR", "USER NAME"};
        Book book = new Book("Abc", "Def", 1900);
        UserInfo userInfo = new UserInfo("ABC", "ABC", "abc@gmail.com");
        CheckedOutBook checkedOutBook = new CheckedOutBook(book, userInfo);
        assertArrayEquals(headerDetails, checkedOutBook.getHeaderDetails());
    }
}
