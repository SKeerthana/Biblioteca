package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CheckOutBooksMenuOptionTest {
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<LibraryItem>());

    @Test
    public void shouldCheckoutBookIfTheBookListContains() {
        String input = "Harry Potter and the Chamber of Secrets";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, inContent);
        Book bookToSearch = new Book(input, null, 0);
        System.setIn(inContent);
        CheckOutBooksMenuOption checkOutBooksMenuOption = new CheckOutBooksMenuOption(bibilioteca, display);

        checkOutBooksMenuOption.performOperation();

        assertFalse(bibilioteca.containsBookInAvailableList(bookToSearch));
    }

    @Test
    public void shouldNotCheckoutBookIfTheBookListDoesNotContain() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, inContent);
        System.setIn(inContent);
        CheckOutBooksMenuOption checkOutBooksMenuOption = new CheckOutBooksMenuOption(bibilioteca, display);
        List<LibraryItem> availableBooks= bibilioteca.getAvailableItems();

        checkOutBooksMenuOption.performOperation();

        assertEquals(availableBooks, bibilioteca.getAvailableItems());
    }

    @Test
    public void shouldPrintMessageForSuccessfulCheckout() {
        String input = "Harry Potter and the Chamber of Secrets";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, inContent);
        System.setIn(inContent);
        CheckOutBooksMenuOption checkOutBooksMenuOption = new CheckOutBooksMenuOption(bibilioteca, display);

        checkOutBooksMenuOption.performOperation();

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldPrintMessageForUnsuccessfulCheckout() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, inContent);
        System.setIn(inContent);
        CheckOutBooksMenuOption checkOutBooksMenuOption = new CheckOutBooksMenuOption(bibilioteca, display);

        checkOutBooksMenuOption.performOperation();

        assertEquals("That book is not available\n", outContent.toString());
    }
}
