package com.thoughtworks.biblioteca.options;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import com.thoughtworks.biblioteca.view.*;

import static org.junit.Assert.assertEquals;

public class InvalidMenuOptionTest {

    @Test
    public void shouldDisplayInvalidMenuMessage() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        InvalidMenuOption invalidMenuOption = new InvalidMenuOption(consoleDisplay);
        invalidMenuOption.performOperation();
        assertEquals("Select a valid option!\n",outContent.toString());
    }
}
