package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MenuOptionControllerTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outContent);
    Display display = new Display(printStream, System.in);
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bookLibraryData = new Biblioteca(listOfBooks, new ArrayList<LibraryItem>());
    Biblioteca movieLibraryData = new Biblioteca(new ArrayList<LibraryItem>(), new ArrayList<LibraryItem>());

    BibliotecaView bibliotecaView = new BibliotecaView(bookLibraryData);
    ArrayList<String> listOfMenuOptions = new ArrayList<String>() {{
        add("1. List all the books");
        add("2. Quit");
        add("3. Checkout books");
        add("4. Return books");
    }};
    Menu menu = new Menu(listOfMenuOptions);

    @Test
    public void shouldDisplayMenuOptions() {
        System.setOut(printStream);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, display);
        menuOptionController.displayMenuOption();
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "1. List all the books\n";
        menuOptions += "2. Quit\n";
        menuOptions += "3. Checkout books\n";
        menuOptions += "4. Return books\n";
        assertEquals(menuOptions, outContent.toString());
    }

    @Test
    public void shouldHandleListOfBooksOption() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, System.in);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, display);

        menuOptionController.handleMenuOption("1");

        assertEquals(bibliotecaView.getFormattedListOfBooks(), outContent.toString());
    }

    @Test
    public void shouldHandleInvalidMenuOption() {
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, display);
        menuOptionController.handleMenuOption("2382");
        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldCallCheckOutBookForOption3() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, inContent);
        System.setIn(inContent);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, display);

        menuOptionController.handleMenuOption("3");

        assertEquals("That book is not available\n", outContent.toString());
    }

    @Test
    public void shouldCallReturnBookForOption4() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        Display display = new Display(printStream, inContent);
        System.setIn(inContent);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, display);

        menuOptionController.handleMenuOption("4");

        assertEquals("That is not a valid book to return.\n", outContent.toString());
    }
}
