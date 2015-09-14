package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class MovieTest {
    @Test
    public void shouldNotBeNull() {
        Movie movie = new Movie("Abc", 1900, "Def", 1);

        assertNotEquals(movie, null);
    }

    @Test
    public void shouldCompareMovieToItself() {
        Movie movie = new Movie("Abc", 1900, "Def", 1);

        assertEquals(movie, movie);
    }

    @Test
    public void shouldNotCompareWithObjectOfAnotherClass() {
        Movie movie = new Movie("", 1202, "asd", 4);

        assertNotEquals(movie, "someStringToCompare");
    }
}
