package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class DisplayTest {

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outContent);
    Display display = new Display(printStream, System.in);


    @Test
    public void shouldPrintTheWelcomeMessagePassed() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        Display display = new Display(printStream, System.in);
        System.setOut(printStream);

        display.printMessage("Welcome to Biblioteca");

        assertEquals("Welcome to Biblioteca", outContent.toString());
    }

    @Test
    public void shouldPrintTheListOfBooks() {
        System.setOut(printStream);

        display.printMessage("My experiments with Truth\t" + "M.K.Gandhi\t" + "1942\n"
                + "Harry Potter and the Chamber of Secrets\t" + "J. K. Rowling\t" + "1998\n");

        assertEquals("My experiments with Truth\t" + "M.K.Gandhi\t" + "1942\n"
                + "Harry Potter and the Chamber of Secrets\t" + "J. K. Rowling\t" + "1998\n", outContent.toString());
    }

    @Test
    public void shouldGetInputFromUser() {
        Display mockDisplay = mock(Display.class);
        when(mockDisplay.getInputFromUser()).thenReturn(1);
        assertEquals(1, mockDisplay.getInputFromUser());
    }
}
