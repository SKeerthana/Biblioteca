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
        Movie movie = new Movie("Abc", 1202, "asd", 4);

        assertNotEquals(movie, "someStringToCompare");
    }

    @Test
    public void shouldBeEqualToOtherInstanceOfSameClassWithSameName() {
        Movie movie1 = new Movie("Abc", 1900,"Def", 1);
        Movie movie2 = new Movie("Abc", 1902,"Deef", 10);

        assertEquals(movie1, movie2);
    }

    @Test
    public void shouldHaveSameHashCodeForSameMovieName() {
        Movie movie1 = new Movie("Abc", 1900,"Def", 1);
        Movie movie2 = new Movie("Abc", 1902,"Deef", 10);

        assertEquals(movie1.hashCode(), movie2.hashCode());
    }

    @Test
    public void shouldHaveDifferentHashCodeForDifferentMovieName() {
        Movie movie1 = new Movie("Abc", 1900,"Def", 1);
        Movie movie2 = new Movie("Abwdf", 1902,"Deef", 10);

        assertNotEquals(movie1.hashCode(), movie2.hashCode());
    }
}
