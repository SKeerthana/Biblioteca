package com.thoughtworks.biblioteca;

import com.thoughtworks.biblioteca.model.CheckedOutBook;
import com.thoughtworks.biblioteca.user.UserAuthenticator;
import com.thoughtworks.biblioteca.view.UserView;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LibraryAppTest {

    com.thoughtworks.biblioteca.model.Book book1 = new com.thoughtworks.biblioteca.model.Book("My experiments with Truth", "M.K.Gandhi", 1942);
    com.thoughtworks.biblioteca.model.Book book2 = new com.thoughtworks.biblioteca.model.Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<com.thoughtworks.biblioteca.model.LibraryItem> listOfBooks = new ArrayList<com.thoughtworks.biblioteca.model.LibraryItem>() {{
        add(book1);
        add(book2);
    }};
    com.thoughtworks.biblioteca.model.Book book3 = new com.thoughtworks.biblioteca.model.Book("Good will hunting", "some person", 1998);
    private com.thoughtworks.biblioteca.user.User currentUser = new com.thoughtworks.biblioteca.user.User("1234-122", "abc", "abc", "", "9944172304", new com.thoughtworks.biblioteca.user.LoggedInUserRole());
    private com.thoughtworks.biblioteca.user.User guestUser = new com.thoughtworks.biblioteca.user.User("guest-001", "abc", "abc", "", "9944172304", new com.thoughtworks.biblioteca.user.GuestRole());
    com.thoughtworks.biblioteca.model.CheckedOutBook checkedOutBook = new CheckedOutBook(book3, currentUser);
    ArrayList<com.thoughtworks.biblioteca.model.LibraryItem> checkedOutBooks = new ArrayList<com.thoughtworks.biblioteca.model.LibraryItem>() {{
        add(checkedOutBook);
    }};
    com.thoughtworks.biblioteca.model.Library bookLibraryData = new com.thoughtworks.biblioteca.model.Library(listOfBooks, checkedOutBooks);
    com.thoughtworks.biblioteca.view.BookView bookView = new com.thoughtworks.biblioteca.view.BookView(bookLibraryData);

    private com.thoughtworks.biblioteca.model.Movie movie = new com.thoughtworks.biblioteca.model.Movie("Vishvaroopam", 2013, "Kamalhasan", 10);
    private ArrayList<com.thoughtworks.biblioteca.model.LibraryItem> availableMovieList = new ArrayList<com.thoughtworks.biblioteca.model.LibraryItem>() {{
        add(movie);
    }};
    private com.thoughtworks.biblioteca.model.Library movieLibraryData = new com.thoughtworks.biblioteca.model.Library(availableMovieList, new ArrayList<com.thoughtworks.biblioteca.model.LibraryItem>());
    private com.thoughtworks.biblioteca.view.MovieView movieView = new com.thoughtworks.biblioteca.view.MovieView(movieLibraryData);

    private com.thoughtworks.biblioteca.model.Menu menu = new com.thoughtworks.biblioteca.model.Menu(currentUser.getMenuOptions());
    private com.thoughtworks.biblioteca.user.User adminUser = new com.thoughtworks.biblioteca.user.User("admin-001", "", "", "", "9944172304", new com.thoughtworks.biblioteca.user.AdminRole());
    private ArrayList<com.thoughtworks.biblioteca.user.User> validUsers = new ArrayList<com.thoughtworks.biblioteca.user.User>() {{
        add(currentUser);
        add(adminUser);
    }};
    private com.thoughtworks.biblioteca.user.UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

    @Test
    public void shouldDisplayListOfBooksForOption1() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("1".getBytes());
        System.setIn(inContent);
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

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
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

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
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

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
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

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
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

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
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

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
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser) + "Thank you! Enjoy the Movie\n", outContent.toString());
    }

    @Test
    public void shouldLoginSuccessfulMessageWhenLoginIsSuccessful() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("7\n1234-122\nabc".getBytes());
        System.setIn(inContent);
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, guestUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(guestUser) + "Enter library Number : Enter password : Login successful\n", outContent.toString());
    }

    @Test
    public void shouldLoginUnSuccessfulMessageWhenLoginIsUnSuccessful() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("7\n3234-122\nabc".getBytes());
        System.setIn(inContent);
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, guestUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(guestUser) + "Enter library Number : Enter password : Login unsuccessful\n", outContent.toString());
    }

    @Test
    public void shouldLogoutSuccessfulMessageWhenLogoutIsSuccessful() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("8\n1234-122\nabc".getBytes());
        System.setIn(inContent);
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser) + "Logout successful\n", outContent.toString());
    }

    @Test
    public void shouldDisplayBookStatusOfCheckedOutBooks() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("8".getBytes());
        System.setIn(inContent);
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, adminUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(adminUser) + bookView.getFormattedListOfCheckedOutItems(), outContent.toString());
    }

    @Test
    public void shouldDisplayUserInformationForLoggedInUser() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("7".getBytes());
        System.setIn(inContent);
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, currentUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(currentUser) + new com.thoughtworks.biblioteca.view.UserView(currentUser).getFormattedUserDetails(), outContent.toString());
    }

    @Test
    public void shouldDisplayUserInformationForAdminUser() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        ByteArrayInputStream inContent = new ByteArrayInputStream("7".getBytes());
        System.setIn(inContent);
        com.thoughtworks.biblioteca.view.ConsoleDisplay consoleDisplay = new com.thoughtworks.biblioteca.view.ConsoleDisplay(printStream, inContent);

        com.thoughtworks.biblioteca.main.BibliotecaApp bibliotecaApp = new com.thoughtworks.biblioteca.main.BibliotecaApp(consoleDisplay);
        com.thoughtworks.biblioteca.controller.MenuOptionController menuOptionController = new com.thoughtworks.biblioteca.controller.MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, adminUser);

        bibliotecaApp.run(menuOptionController);
        assertEquals(menu.getMenuOptionsToDisplay(adminUser) + new UserView(adminUser).getFormattedUserDetails(), outContent.toString());
    }
}
