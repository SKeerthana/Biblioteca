package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MovieViewTest {
    private Movie movie = new Movie("Vishvaroopam", 2013, "Kamalhasan", 10);
    private ArrayList<LibraryItem> availableMovieList = new ArrayList<LibraryItem>() {{
        add(movie);
    }};

    @Test
    public void shouldFormattedListOfMovies() {
        Biblioteca movieLibraryData = new Biblioteca(availableMovieList, new ArrayList<LibraryItem>());
        MovieView movieView = new MovieView(movieLibraryData);
        String displayData = "=====================================================================================\n";
        displayData += String.format("%-25s %-25s %-15s %-15s\n", "MOVIE NAME", "DIRECTOR", "YEAR", "RATINGS");
        displayData += "=====================================================================================\n";
        displayData += String.format("%-25s %-25s %-15s %-15s\n", "Vishvaroopam", "Kamalhasan", "2013", "10");
        displayData += "=====================================================================================\n";
        assertEquals(displayData, movieView.getFormattedListOfItems());
    }

    @Test
    public void shouldDisplayFeatureNotSupportedToDisplayCheckedOutMovies() {
        Biblioteca movieLibraryData = new Biblioteca(availableMovieList, new ArrayList<LibraryItem>());
        MovieView movieView = new MovieView(movieLibraryData);
        assertEquals("Feature not supported", movieView.getFormattedListOfCheckedOutItems());
    }
}