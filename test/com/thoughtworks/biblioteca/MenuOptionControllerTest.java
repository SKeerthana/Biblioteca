package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    Book book3 = new Book("Good will hunting", "some person", 1998);
    ArrayList<LibraryItem> checkedOutBooks = new ArrayList<LibraryItem>() {{
        add(book3);
    }};

    Biblioteca bookLibraryData = new Biblioteca(listOfBooks, checkedOutBooks);

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
    private User user1 = new User("abc", "abc", "abc", "", new AdminRole());
    private HashMap<String, User> validUsers = new HashMap<String, User>() {{
        put("1234-122", user1);
    }};
    private UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

    private User currentUser = new User("1234-122", "abc", "abc", "", new AdminRole());
    private User guestUser = new User("guest-001", "", "", "", new GuestRole());

    @Test
    public void shouldDisplayMenuOptions() {
        System.setOut(printStream);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, guestUser);
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
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        menuOptionController.handleMenuOption("1");

        assertEquals(bookView.getFormattedListOfItems(), outContent.toString());
    }

    @Test
    public void shouldHandleInvalidMenuOption() {
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        menuOptionController.handleMenuOption("2382");

        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldAllowCheckOutBookForLoggedInUserForOption3() {
        String input = "Harry Potter and the Chamber of Secrets";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        menuOptionController.handleMenuOption("3");

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldPromptLoginForGuestUserForOption3() {
        String input = "Harry Potter and the Chamber of Secrets";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        UserAuthenticator mockUserAuthenticator = mock(UserAuthenticator.class);
        when(mockUserAuthenticator.loginUser(consoleDisplay)).thenReturn(guestUser);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, mockUserAuthenticator, guestUser);

        menuOptionController.handleMenuOption("3");

        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldAllowCheckOutBookAfterSuccessfulLoginByGuestUserForOption3() {
        String input = "Harry Potter and the Chamber of Secrets";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        UserAuthenticator mockUserAuthenticator = mock(UserAuthenticator.class);
        when(mockUserAuthenticator.loginUser(consoleDisplay)).thenReturn(currentUser);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, mockUserAuthenticator, guestUser);

        menuOptionController.handleMenuOption("3");

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldPromptLoginForGuestUserToReturnBookForOption4() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        UserAuthenticator mockUserAuthenticator = mock(UserAuthenticator.class);
        when(mockUserAuthenticator.loginUser(consoleDisplay)).thenReturn(guestUser);

        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, mockUserAuthenticator, guestUser);

        menuOptionController.handleMenuOption("4");

        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldAllowReturnBookForGuestUserAfterSuccessfulLoginOption4() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        UserAuthenticator mockUserAuthenticator = mock(UserAuthenticator.class);
        when(mockUserAuthenticator.loginUser(consoleDisplay)).thenReturn(guestUser);

        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, mockUserAuthenticator, guestUser);

        menuOptionController.handleMenuOption("4");

        assertEquals("Select a valid option!\n", outContent.toString());
    }

    @Test
    public void shouldAllowLoggedInUserToReturnBookForOption4() {
        String input = "Good will hunting";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);
        System.setIn(inContent);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        menuOptionController.handleMenuOption("4");

        assertEquals("Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void shouldListMenuItemToDisplayListOfMovies() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

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
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);
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
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);
        menuOptionController.handleMenuOption("7");

        assertEquals("Enter library Number : Enter password : Login Successful\n", outContent.toString());
    }
}
