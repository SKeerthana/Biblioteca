package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<LibraryItem>());
    BookView bookView = new BookView(bibilioteca);
    ArrayList<String> listOfMenuOptions = new ArrayList<String>() {{
        add("1. List all the books");
        add("2. Quit");
        add("3. Checkout books");
        add("3. Checkout books");
    }};
    Menu menu = new Menu(listOfMenuOptions);

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldDisplayListOfBooksOptionsAfterDisplayingWelcomeMessage() {
        ConsoleDisplay consoleDisplay1 = mock(ConsoleDisplay.class);
        when(consoleDisplay1.getInputFromUser()).thenReturn("1", "2");
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu, consoleDisplay1);
        MenuOptionController menuOptionController = mock(MenuOptionController.class);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        ListLibraryItemMenuOption listLibraryItemMenuOption = new ListLibraryItemMenuOption(bookView, consoleDisplay);
        when(menuOptionController.getMenuOption("1")).thenReturn(listLibraryItemMenuOption);
        exit.expectSystemExit();

        bibliotecaApp.start();
        assertEquals(bookView.getFormattedListOfItems(), outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessMessageWhenCheckOutIsSuccessful() {
        ConsoleDisplay consoleDisplay1 = mock(ConsoleDisplay.class);
        when(consoleDisplay1.getInputFromUser()).thenReturn("3", "2");
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu, consoleDisplay1);
        MenuOptionController menuOptionController = mock(MenuOptionController.class);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("Harry Potter and the Chamber of Secrets".getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        CheckOutBooksMenuOption checkOutBooksMenuOption = new CheckOutBooksMenuOption(bibilioteca, consoleDisplay, new User("ABC12", "ABC23", "", "abc@gmail.com", Role.ADMIN));
        when(menuOptionController.getMenuOption("3")).thenReturn(checkOutBooksMenuOption);
        exit.expectSystemExit();

        bibliotecaApp.start();
        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }
}
