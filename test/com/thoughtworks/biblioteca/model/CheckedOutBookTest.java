package com.thoughtworks.biblioteca.model;

import com.thoughtworks.biblioteca.user.*;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class CheckedOutBookTest {
    private User currentUser = new User("abc", "abc", "abc", "", "9944172304", new LoggedInUserRole());
    private User currentUser1 = new User("a12bc", "abc", "abc", "", "9944172304", new LoggedInUserRole());

    @Test
    public void shouldReturnHeaderDetailsOfBookAndUserName() {
        String[] headerDetails = {"BOOK NAME", "AUTHOR", "YEAR", "LIBRARY NUMBER"};
        Book book = new Book("Abc", "Def", 1900);
        User user = new User("abc", "abc", "abc", "", "9944172304", new AdminRole());
        CheckedOutBook checkedOutBook = new CheckedOutBook(book, user);
        assertArrayEquals(headerDetails, checkedOutBook.getHeaderDetails());
    }

    @Test
    public void shouldNotBeNull() {
        Book book = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook = new CheckedOutBook(book, currentUser);

        assertNotEquals(checkedOutBook, null);
    }

    @Test
    public void shouldBeEqualToItself() {
        Book book = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook = new CheckedOutBook(book, currentUser);

        assertEquals(checkedOutBook, checkedOutBook);
    }

    @Test
    public void shouldBeEqualToOtherInstanceOfSameClassWithSameName() {
        Book book1 = new Book("Abc", "Dwwef", 1200);
        CheckedOutBook checkedOutBook1 = new CheckedOutBook(book1, currentUser);
        Book book2 = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook2 = new CheckedOutBook(book2, currentUser);

        assertEquals(checkedOutBook1, checkedOutBook2);
    }

    @Test
    public void shouldBeEqualIfAllAttributesAreSame() {
        Book book1 = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook1 = new CheckedOutBook(book1, currentUser);
        Book book2 = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook2 = new CheckedOutBook(book2, currentUser);

        assertEquals(checkedOutBook1, checkedOutBook2);
    }

    @Test
    public void shouldBeNotBeEqualIfUsersAreDifferent() {
        Book book1 = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook1 = new CheckedOutBook(book1, currentUser);
        Book book2 = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook2 = new CheckedOutBook(book2, currentUser1);

        assertNotEquals(checkedOutBook1, checkedOutBook2);
    }

    @Test
    public void shouldNotBeEqualIfNameISDifferent() {
        Book book1 = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook1 = new CheckedOutBook(book1, currentUser);
        Book book2 = new Book("Abc1", "Def", 1900);
        CheckedOutBook checkedOutBook2 = new CheckedOutBook(book2, currentUser);

        assertNotEquals(checkedOutBook1, checkedOutBook2);
    }

    @Test
    public void shouldNotBeEqualToAnotherType() {
        Book book = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook = new CheckedOutBook(book, currentUser);

        assertNotEquals(checkedOutBook, "some string");
    }

    @Test
    public void shouldHaveSameHashCodeForSameBookTitle() {
        Book book1 = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook1 = new CheckedOutBook(book1, currentUser);
        Book book2 = new Book("Abc", "Xyz", 2000);
        CheckedOutBook checkedOutBook2 = new CheckedOutBook(book2, currentUser);

        assertEquals(checkedOutBook1.hashCode(), checkedOutBook2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeForDifferentBookTitle() {
        Book book1 = new Book("Abc", "Def", 1900);
        CheckedOutBook checkedOutBook1 = new CheckedOutBook(book1, currentUser);
        Book book2 = new Book("Xyz", "Def", 1900);
        CheckedOutBook checkedOutBook2 = new CheckedOutBook(book2, currentUser1);

        assertNotEquals(checkedOutBook1.hashCode(), checkedOutBook2.hashCode());
    }
}
