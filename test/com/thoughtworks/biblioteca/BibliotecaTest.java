package com.thoughtworks.biblioteca;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class BibliotecaTest {

    @Test
    public void shouldCallStartFunctionOnlyOnce() {
        Biblioteca biblioteca = mock(Biblioteca.class);
        biblioteca.start();
        Mockito.verify(biblioteca, times(1)).start();
    }

    @Test
    public void shouldCallPrintMethod() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.start();
        assertEquals("Welcome to Biblioteca" + "\n", outContent.toString());
    }
}
