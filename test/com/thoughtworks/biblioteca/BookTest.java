package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {

    @Test
    public void shouldReturnTheBookDetails() {
        Book book = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
        assertEquals("My experiments with Truth" + "\t" + "M.K.Gandhi" + "\t" + "1942" + "\n", book.getBookDetails());
    }

    @Test
    public void shouldNotBeNull() {
        Book book = new Book("Abc", "Def", 1900);

        assertNotEquals(book, null);
    }

    @Test
    public void shouldBeEqualToItself() {
        Book book = new Book("Abc", "Def", 1900);

        assertEquals(book, book);
    }

    @Test
    public void shouldBeEqualToOtherInstanceOfSameClassWithSameName() {
        Book book1 = new Book("Abc", "Dwwef", 1200);
        Book book2 = new Book("Abc", "Def", 1900);

        assertEquals(book1, book2);
    }

    @Test
    public void shouldBeEqualIfAllAttributesAreSame() {
        Book book1 = new Book("Abc", "Def", 1900);
        Book book2 = new Book("Abc", "Def", 1900);

        assertEquals(book1, book2);
    }

    @Test
    public void shouldNotBeEqualIfNameISDifferent() {
        Book book1 = new Book("Abc", "Def", 1900);
        Book book2 = new Book("Abc", "Def", 1900);

        assertEquals(book1, book2);
    }

    @Test
    public void shouldNotBeEqualToAnotherType() {
        Book book = new Book("Abc", "Def", 1900);

        assertNotEquals(book, "some string");
    }

    @Test
    public void shouldHaveSameHashCodeForSameBookTitle() {
        Book book1 = new Book("Abc", "Def", 1900);
        Book book2 = new Book("Abc", "Xyz", 2000);

        assertEquals(book1.hashCode(), book2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeForDifferentBookTitle() {
        Book book1 = new Book("Abc", "Def", 1900);
        Book book2 = new Book("Xyz", "Def", 1900);

        assertNotEquals(book1.hashCode(), book2.hashCode());
    }
}
