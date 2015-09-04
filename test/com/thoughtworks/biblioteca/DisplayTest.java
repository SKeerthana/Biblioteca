package com.thoughtworks.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class DisplayTest {

    @Test
    public void shouldPrintTheMessagePassed() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        Display display = new Display(printStream);
        System.setOut(printStream);

        display.printMessage("Welcome to Biblioteca");
        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }
}
