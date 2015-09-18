package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaAppTest {

    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<LibraryItem> listOfBooks = new ArrayList<LibraryItem>() {{
        add(book1);
        add(book2);
    }};
    Book book3 = new Book("Good will hunting", "some person", 1998);
    private User currentUser = new User("1234-122", "abc", "abc", "", "9944172304", new LoggedInUserRole());
    CheckedOutBook checkedOutBook = new CheckedOutBook(book3, currentUser);
    ArrayList<LibraryItem> checkedOutBooks = new ArrayList<LibraryItem>() {{
        add(checkedOutBook);
    }};
    Biblioteca bookLibraryData = new Biblioteca(listOfBooks, checkedOutBooks);
    BookView bookView = new BookView(bookLibraryData);

    private Movie movie = new Movie("Vishvaroopam", 2013, "Kamalhasan", 10);
    private ArrayList<LibraryItem> availableMovieList = new ArrayList<LibraryItem>() {{
        add(movie);
    }};
    private Biblioteca movieLibraryData = new Biblioteca(availableMovieList, new ArrayList<LibraryItem>());
    private MovieView movieView = new MovieView(movieLibraryData);

    private Menu menu = new Menu(currentUser.getMenuOptions());
    private User adminUser = new User("admin-001", "", "", "", "9944172304", new AdminRole());
    private ArrayList<User> validUsers = new ArrayList<User>() {{
        add(currentUser);
        add(adminUser);
    }};
    private UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

    @Test
    public void shouldDisplayListOfBooksForOption1() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleDisplay);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser) + bookView.getFormattedListOfItems(), outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessMessageWhenCheckOutBookIsSuccessful() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("3\nMy experiments with Truth\n".getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleDisplay);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser) + "Thank you! Enjoy the book\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnSuccessMessageWhenCheckOutBookIsUnSuccessful() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("3\nMy experiments\n".getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleDisplay);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser) + "That book is not available\n", outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessMessageWhenReturnBookIsSuccessful() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("4\nGood will hunting\n".getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleDisplay);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser) + "Thank you for returning the book.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayUnSuccessMessageWhenReturnBookIsUnSuccessful() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("4\nGood will\n".getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleDisplay);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser) + "That is not a valid book to return.\n", outContent.toString());
    }

    @Test
    public void shouldDisplayListOfBooksForOption5() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("5".getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleDisplay);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser) + movieView.getFormattedListOfItems(), outContent.toString());
    }

    @Test
    public void shouldDisplaySuccessMessageWhenCheckOutMovieIsSuccessful() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("6\nVishvaroopam\n".getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleDisplay);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser) + "Thank you! Enjoy the Movie\n", outContent.toString());
    }

    @Test
    public void shouldDisplayNothingWhenCheckOutMovieIsUnSuccessful() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("6\nVishva\n".getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, inContent);

        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleDisplay);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser), outContent.toString());
    }
}
