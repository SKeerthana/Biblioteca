package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ListBooksMenuOptionTest {

    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<Book> listOfBooks = new ArrayList<Book>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<Book>());

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outContent);
    Display display = new Display(printStream, System.in);

    @Test
    public void shouldDisplayListOfBooks() {
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(bibilioteca, display);

        listBooksMenuOption.performOperation();
        String header = "=====================================================================================\n";
        header += String.format("%-50s %-25s %-15s", "BOOK NAME", "AUTHOR", "YEAR");
        header += "=====================================================================================";
        header += bibilioteca.getListOfBooks();
        header += "=====================================================================================";
        assertEquals(header, outContent.toString());
    }
}
