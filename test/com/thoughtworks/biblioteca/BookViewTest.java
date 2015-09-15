package com.thoughtworks.biblioteca;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookViewTest {
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<LibraryItem>());

    @Test
    public void shouldReturnListOfBooks() {
        BookView bookView = new BookView(bibilioteca);
        String header = "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s\n", "BOOK NAME", "AUTHOR", "YEAR");
        header += "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s\n", "My experiments with Truth", "M.K.Gandhi", "1942");
        header += "=====================================================================================\n";
        assertEquals(header, bookView.getFormattedListOfItems());
    }
}
