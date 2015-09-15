package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

public class CheckOutMoviesMenuOptionTest {
    Movie movie1 = new Movie("Vishvaroopam", 2013, "Kamalhasan", 10);
    Movie movie2 = new Movie("The Dark Knight Returns", 2013, "Frank Miller", 10);
    ArrayList<LibraryItem> availableListOfMovies = new ArrayList<LibraryItem>() {{
        add(movie1);
        add(movie2);
    }};
    Biblioteca movieLibraryData = new Biblioteca(availableListOfMovies, new ArrayList<LibraryItem>());

    @Test
    public void shouldCheckoutBookIfTheBookListContains() {
        String input = "Vishvaroopam";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, inContent);
        Book bookToSearch = new Book(input, null, 0);
        System.setIn(inContent);
        CheckOutBooksMenuOption checkOutBooksMenuOption = new CheckOutBooksMenuOption(movieLibraryData, display);

        checkOutBooksMenuOption.performOperation();

        assertFalse(movieLibraryData.containsBookInAvailableList(bookToSearch));
    }
}
