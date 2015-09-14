package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaViewTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outContent);
    Display display = new Display(printStream, System.in);
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    ArrayList<Book> listOfBooks = new ArrayList<Book>() {{
        add(book1);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<Book>());

    @Test
    public void shouldReturnListOfBooks() {
        BibliotecaView bibliotecaView = new BibliotecaView(bibilioteca);
        String header = "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s\n", "BOOK NAME", "AUTHOR", "YEAR");
        header += "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s\n", "My experiments with Truth", "M.K.Gandhi", "1942");
        header += "=====================================================================================\n";
        assertEquals(header, bibliotecaView.getFormattedListOfBooks());
    }
}
