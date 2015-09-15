package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MovieViewTest {
    @Test
    public void shouldFormattedListOfMovies() {
        Biblioteca movieLibraryData = new Biblioteca(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>());
        MovieView movieView = new MovieView(movieLibraryData);
        assertEquals("movie data", movieView.getFormattedListOfItems());
    }
}