package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;

public class MovieTest {
    @Test
    public void shouldNotBeNull() {
        Movie movie = new Movie("Abc", 1900,"Def", 1);

        assertNotEquals(movie, null);
    }

}
