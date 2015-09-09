package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReturnBookOptionTest {
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<Book> listOfAvailableBooks = new ArrayList<Book>() {{
        add(book1);
    }};
    ArrayList<Book> listOfCheckedOutBooks = new ArrayList<Book>() {{
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfAvailableBooks, listOfCheckedOutBooks);

    @Test
    public void shouldPrintMessageForSuccessfulReturn() {
        String input = "Harry Potter and the Chamber of Secrets";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, inContent);
        System.setIn(inContent);

        ReturnBookOption returnBookOption = new ReturnBookOption(bibilioteca, display);
        returnBookOption.performOperation();

        assertEquals("Thank you for returning the book.", outContent.toString());
    }

    @Test
    public void shouldPrintMessageForUnSuccessfulReturn() {
        String input = "My experiments with Truth";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, inContent);
        System.setIn(inContent);

        ReturnBookOption returnBookOption = new ReturnBookOption(bibilioteca, display);
        returnBookOption.performOperation();

        assertEquals("That is not a valid book to return.", outContent.toString());
    }
}
