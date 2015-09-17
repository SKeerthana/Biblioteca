package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LoginMenuOptionTest {

    @Test
    public void shouldDisplayLoginSuccessfulForLoggedInUser() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        String input = "1234-122" + "\n" + "abc";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        User loggedInUser = new User("1234-122", "abc", "abc", "abc@gmail.com", new LoggedInUserRole());
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleDisplay, loggedInUser);

        loginMenuOption.performOperation();

        assertEquals("Login successful\n", outContent.toString());
    }

    @Test
    public void shouldDisplayLoginUnSuccessfulForGuestUser() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        String input = "1234-122" + "\n" + "abc12";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        User guestUser = new User("1234-122", "abc", "abc", "abc@gmail.com", new GuestRole());
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleDisplay, guestUser);

        loginMenuOption.performOperation();

        assertEquals("Login unsuccessful\n", outContent.toString());
    }

    @Test
    public void shouldDisplayLoginUnSuccessfulForAdmin() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        String input = "1234-122" + "\n" + "abc12";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        User admin = new User("1234-122", "abc", "abc", "abc@gmail.com", new AdminRole());
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleDisplay, admin);

        loginMenuOption.performOperation();

        assertEquals("Login successful\n", outContent.toString());
    }
}
