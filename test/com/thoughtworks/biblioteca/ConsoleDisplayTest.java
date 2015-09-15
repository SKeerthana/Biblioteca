package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class ConsoleDisplayTest {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outContent);
    ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);


    @Test
    public void shouldPrintTheWelcomeMessagePassed() {
        System.setOut(printStream);

        consoleDisplay.printMessage("Welcome to Biblioteca");

        assertEquals("Welcome to Biblioteca", outContent.toString());
    }

    @Test
    public void shouldPrintTheListOfBooks() {
        System.setOut(printStream);

        consoleDisplay.printMessage("My experiments with Truth\t" + "M.K.Gandhi\t" + "1942\n"
                + "Harry Potter and the Chamber of Secrets\t" + "J. K. Rowling\t" + "1998\n");

        assertEquals("My experiments with Truth\t" + "M.K.Gandhi\t" + "1942\n"
                + "Harry Potter and the Chamber of Secrets\t" + "J. K. Rowling\t" + "1998\n", outContent.toString());
    }

    @Test
    public void shouldGetMenuOptionFromUser() {
        String input = "1";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);

        ConsoleDisplay mockConsoleDisplay = new ConsoleDisplay(System.out, inContent);
        mockConsoleDisplay.getInputFromUser();
        assertEquals("1", input);
    }

    @Test
    public void shouldGetStringInputFromUser() {
        String input = "Harry Potter and the Chamber of Secrets";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.out, inContent);

        System.setIn(inContent);
        assertEquals("Harry Potter and the Chamber of Secrets", consoleDisplay.getInputFromUser());
    }
}
