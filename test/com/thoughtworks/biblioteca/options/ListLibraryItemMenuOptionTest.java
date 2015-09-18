package com.thoughtworks.biblioteca.options;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import com.thoughtworks.biblioteca.model.*;
import com.thoughtworks.biblioteca.view.*;

import static org.junit.Assert.assertEquals;

public class ListLibraryItemMenuOptionTest {

    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
    }};
    Library bibilioteca = new Library(listOfBooks, new ArrayList<LibraryItem>());

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outContent);
    ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
    BookView bookView = new BookView(bibilioteca);

    @Test
    public void shouldDisplayListOfBooks() {
        ListLibraryItemMenuOption listLibraryItemMenuOption = new ListLibraryItemMenuOption(bookView, consoleDisplay);

        listLibraryItemMenuOption.performOperation();
        String header = "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s\n", "BOOK NAME", "AUTHOR", "YEAR");
        header += "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s\n", "My experiments with Truth", "M.K.Gandhi", "1942");
        header += "=====================================================================================\n";
        assertEquals(header, outContent.toString());
    }
}
