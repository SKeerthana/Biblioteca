package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CheckOutMoviesMenuOptionTest {
    Movie movie1 = new Movie("Vishvaroopam", 2013, "Kamalhasan", 10);
    Movie movie2 = new Movie("The Dark Knight Returns", 2013, "Frank Miller", 10);
    ArrayList<LibraryItem> availableListOfMovies = new ArrayList<LibraryItem>() {{
        add(movie1);
        add(movie2);
    }};
    Library movieLibraryData = new Library(availableListOfMovies, new ArrayList<LibraryItem>());

    @Test
    public void shouldCheckoutMovieIfTheMovieIsInAvailableList() {
        String input = "Vishvaroopam";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        CheckOutMoviesMenuOption checkOutMoviesMenuOption = new CheckOutMoviesMenuOption(movieLibraryData, consoleDisplay);

        checkOutMoviesMenuOption.performOperation();

        assertEquals("Thank you! Enjoy the Movie\n", outContent.toString());
    }

    @Test
    public void shouldNotCheckoutMovieIfTheMovieListDoesNotContain() {
        String input = "Vishvaroopam";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        CheckOutMoviesMenuOption checkOutMoviesMenuOption = new CheckOutMoviesMenuOption(movieLibraryData, consoleDisplay);
        List<LibraryItem> availableItems = movieLibraryData.getAvailableItems();

        checkOutMoviesMenuOption.performOperation();

        assertEquals(availableItems, movieLibraryData.getAvailableItems());
    }

    @Test
    public void shouldNotReturnMovieWhichIsNotInCheckedOutList() {
        String input = "Vishvaroo";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        CheckOutMoviesMenuOption checkOutMoviesMenuOption = new CheckOutMoviesMenuOption(movieLibraryData, consoleDisplay);

        checkOutMoviesMenuOption.performOperation();

        assertEquals("", outContent.toString());
    }
}
