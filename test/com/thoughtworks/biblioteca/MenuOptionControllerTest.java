package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuOptionControllerTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outContent);
    Display display = new Display(printStream, System.in);
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<Book> listOfBooks = new ArrayList<Book>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<Book>());
    Menu menu = new Menu();

    @Test
    public void shouldDisplayMenuOptions() {
        System.setOut(printStream);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bibilioteca, display);
        menuOptionController.displayMenuOption();
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "1. List all the books\n";
        menuOptions += "2. Quit\n";
        menuOptions += "3. Checkout books\n";
        assertEquals(menuOptions, outContent.toString());
    }

    @Test
    public void shouldHandleListOfBooksOption() {
        MenuOptionController menuOptionController = new MenuOptionController(menu, bibilioteca, display);
        menuOptionController.handleMenuOption("1");
        System.setOut(printStream);
        assertEquals(bibilioteca.getListOfBooks(), outContent.toString());
    }

    @Test
    public void shouldHandleInvalidMenuOption() {
        MenuOptionController menuOptionController = new MenuOptionController(menu, bibilioteca, display);
        menuOptionController.handleMenuOption("2382");
        assertEquals("Select a valid option!", outContent.toString());
    }


    @Test
    public void shouldCheckOutBookForOption4() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, inContent);
        System.setIn(inContent);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bibilioteca, display);

        menuOptionController.handleMenuOption("3");

        assertEquals("That book is not available", outContent.toString());
    }
}
