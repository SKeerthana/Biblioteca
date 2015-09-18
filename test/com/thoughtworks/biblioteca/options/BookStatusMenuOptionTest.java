package com.thoughtworks.biblioteca.options;


import com.thoughtworks.biblioteca.model.*;
import com.thoughtworks.biblioteca.user.*;
import com.thoughtworks.biblioteca.view.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BookStatusMenuOptionTest {
    Book book2 = new Book("Good will hunting", "some person", 1998);
    User user = new User("ABC", "ABC", "", "abc@gmail.com", "9944172304", new LoggedInUserRole());
    CheckedOutBook checkedOutBook = new CheckedOutBook(book2, user);
    ArrayList<LibraryItem> checkedOutBooks = new ArrayList<LibraryItem>() {{
        add(checkedOutBook);
    }};
    Library bibilioteca = new Library(new ArrayList<LibraryItem>(), checkedOutBooks);

    @Test
    public void shouldDisplayListOfCheckedOutBooks() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        BookView bookView = new BookView(bibilioteca);
        BookStatusMenuOption bookStatusMenuOption = new BookStatusMenuOption(bookView, consoleDisplay);
        String header = "==========================================================================================================================\n";
        header += String.format("%-50s %-25s %-15s %-25s\n", "BOOK NAME", "AUTHOR", "YEAR", "LIBRARY NUMBER");
        header += "==========================================================================================================================\n";
        header += String.format("%-50s %-25s %-15s %-25s\n", "Good will hunting", "some person", "1998", "ABC");
        header += "==========================================================================================================================\n";

        bookStatusMenuOption.performOperation();

        assertEquals(header, outContent.toString());
    }
}
