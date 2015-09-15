package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListBooksMenuOptionTest {

    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<LibraryItem>());

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outContent);
    Display display = new Display(printStream, System.in);
    BibliotecaView bibliotecaView = new BibliotecaView(bibilioteca);

    @Test
    public void shouldDisplayListOfBooks() {
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(bibliotecaView, display);

        listBooksMenuOption.performOperation();
        String header = "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s\n", "BOOK NAME", "AUTHOR", "YEAR");
        header += "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s\n", "My experiments with Truth", "M.K.Gandhi", "1942");
        header += "=====================================================================================\n";
        assertEquals(header, outContent.toString());
    }
}
