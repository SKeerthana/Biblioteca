package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class InvalidMenuOptionTest {

    @Test
    public void shouldDisplayInvalidMenuMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        Display display = new Display(printStream, System.in);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption(display);
        invalidMenuOption.performOperation();
        assertEquals("Select a valid option!\n",outContent.toString());
    }
}
