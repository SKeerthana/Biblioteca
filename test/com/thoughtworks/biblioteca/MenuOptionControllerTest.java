package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MenuOptionControllerTest {
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outContent);
    ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bookLibraryData = new Biblioteca(listOfBooks, new ArrayList<LibraryItem>());

    private Movie movie = new Movie("Vishvaroopam", 2013, "Kamalhasan", 10);
    private ArrayList<LibraryItem> availableMovieList = new ArrayList<LibraryItem>() {{
        add(movie);
    }};
    private Biblioteca movieLibraryData = new Biblioteca(availableMovieList, new ArrayList<LibraryItem>());

    private BookView bookView = new BookView(bookLibraryData);
    private MovieView movieView = new MovieView(movieLibraryData);

    private ArrayList<String> listOfMenuOptions = new ArrayList<String>() {{
        add("1. List all the books");
        add("2. Quit");
        add("3. Checkout books");
        add("4. Return books");
    }};
    private Menu menu = new Menu(listOfMenuOptions);
    private UserInfo userInfo1 = new UserInfo("abc", "abc", "abc", "", Role.ADMIN);
    private HashMap<String, UserInfo> validUsers = new HashMap<String, UserInfo>() {{
        put("1234-122", userInfo1);
    }};
    private UserManager userManager = new UserManager(validUsers);

    @Test
    public void shouldDisplayMenuOptions() {
        System.setOut(printStream);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userManager);
        menuOptionController.displayMenuOption();
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "List Books\n";
        menuOptions += "Quit\n";
        menuOptions += "CheckOut Book\n";
        menuOptions += "Return Book\n";
        menuOptions += "List Movies\n";
        menuOptions += "CheckOut Movie\n";
        menuOptions += "Log in\n";

        assertEquals(menuOptions, outContent.toString());
    }

    @Test
    public void shouldHandleListOfBooksOption() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userManager);

        menuOptionController.handleMenuOption("1");

        assertEquals(bookView.getFormattedListOfItems(), outContent.toString());
    }

    @Test
    public void shouldHandleInvalidMenuOption() {
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userManager);

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
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userManager);

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
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userManager);

        menuOptionController.handleMenuOption("4");

        assertEquals("That is not a valid book to return.\n", outContent.toString());
        }

    @Test
    public void shouldListMenuItemToDisplayListOfMovies() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userManager);

        menuOptionController.handleMenuOption("5");

        assertEquals(movieView.getFormattedListOfItems(), outContent.toString());
    }

    @Test
    public void shouldCallCheckOutMovieForOption6() {
        String input = "Vishvaroopam";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userManager);
        menuOptionController.handleMenuOption("6");

        assertEquals("Thank you! Enjoy the Movie\n", outContent.toString());
    }

    @Test
    public void shouldCallLoginMenuOptionForOption7() {
        String input = "1234-122" + "\n" + "abc";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userManager);
        menuOptionController.handleMenuOption("7");

        assertEquals("Enter Library Number : Enter Password : Login Successful\n", outContent.toString());
    }
}
