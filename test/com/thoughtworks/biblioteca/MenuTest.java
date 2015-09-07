package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuTest {

    final Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    final Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<Book> listOfBooks = new ArrayList<Book>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks);

    @Test
    public void shouldReturnTheListOFMenuOptions() {
        Display display = new Display(System.out, System.in);
        Menu menu = new Menu(bibilioteca, display);
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "1. List all the books\n";
        menuOptions += "2. Quit\n";
        menuOptions += "3. Checkout books";
        assertEquals(menuOptions, menu.getMenuOptions());
    }

    @Test
    public void shouldHandleTheSelectedOption() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        Display display = new Display(printStream, System.in);
        Menu menu = new Menu(bibilioteca, display);

        System.setOut(printStream);
        menu.handleSelectedMenuOption(1);

        assertEquals(bibilioteca.getListOfBooks(), outContent.toString());
    }

    @Test
    public void shouldHandleTheInvalidMenuOption() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        Display display = new Display(printStream, System.in);
        Menu menu = new Menu(bibilioteca, display);

        System.setOut(printStream);
        menu.handleSelectedMenuOption(112);

        assertEquals("Select a valid option!\n", outContent.toString());
    }
}
