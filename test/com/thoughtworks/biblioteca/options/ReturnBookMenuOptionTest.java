package com.thoughtworks.biblioteca.options;

import com.thoughtworks.biblioteca.model.*;
import com.thoughtworks.biblioteca.user.*;
import com.thoughtworks.biblioteca.view.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ReturnBookMenuOptionTest {
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    User currentlyLoggedInUser = new User("admin-001", "abc", "abc", "", "9944172304", new AdminRole());
    CheckedOutBook checkedOutBook = new CheckedOutBook(book2, currentlyLoggedInUser);
    ArrayList<LibraryItem> listOfAvailableBooks = new ArrayList<LibraryItem>() {{
        add(book1);
    }};
    ArrayList<LibraryItem> listOfCheckedOutBooks = new ArrayList<LibraryItem>() {{
        add(checkedOutBook);
    }};
    Library bibilioteca = new Library(listOfAvailableBooks, listOfCheckedOutBooks);

    @Test
    public void shouldPrintMessageForSuccessfulReturn() {
        String input = "Harry Potter and the Chamber of Secrets";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);

        ReturnBookMenuOption returnBookMenuOption = new ReturnBookMenuOption(bibilioteca, consoleDisplay, currentlyLoggedInUser);
        returnBookMenuOption.performOperation();

        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void shouldPrintMessageForUnSuccessfulReturn() {
        String input = "My experiments with Truth";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);

        ReturnBookMenuOption returnBookMenuOption = new ReturnBookMenuOption(bibilioteca, consoleDisplay, currentlyLoggedInUser);
        returnBookMenuOption.performOperation();

        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }
}
