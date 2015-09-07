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
    public void shouldGetMenuOptionFromUser() {
        Display mockDisplay = mock(Display.class);
        when(mockDisplay.getInputMenuOptionFromUser()).thenReturn(1);
        assertEquals(1, mockDisplay.getInputMenuOptionFromUser());
    }

    @Test
    public void shouldGetStringInputFromUser() {
        String input = "Harry Potter and the Chamber of Secrets";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        Display display = new Display(System.out, inContent);

        System.setIn(inContent);
        assertEquals("Harry Potter and the Chamber of Secrets", display.getInputFromUser());
    }
}
