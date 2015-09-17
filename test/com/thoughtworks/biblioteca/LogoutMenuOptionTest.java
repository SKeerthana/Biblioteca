package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LogoutMenuOptionTest {

    @Test
    public void shouldDisplayLogoutUnSuccessfulForLoggedInUser() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        String input = "1234-122" + "\n" + "abc";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        User loggedInUser = new User("1234-122", "abc", "abc", "abc@gmail.com", new LoggedInUserRole());
        LogoutMenuOption logoutMenuOption = new LogoutMenuOption(consoleDisplay, loggedInUser);

        logoutMenuOption.performOperation();

        assertEquals("Logout unsuccessful\n", outContent.toString());
    }

    @Test
    public void shouldDisplayLogoutSuccessfulForGuestUser() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        String input = "1234-122" + "\n" + "abc12";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        User guestUser = new User("1234-122", "abc", "abc", "abc@gmail.com", new GuestRole());
        LogoutMenuOption logoutMenuOption = new LogoutMenuOption(consoleDisplay, guestUser);

        logoutMenuOption.performOperation();

        assertEquals("Logout successful\n", outContent.toString());
    }

    @Test
    public void shouldDisplayLogoutUnSuccessfulForAdmin() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        String input = "1234-122" + "\n" + "abc12";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        User admin = new User("1234-122", "abc", "abc", "abc@gmail.com", new AdminRole());
        LogoutMenuOption logoutMenuOption = new LogoutMenuOption(consoleDisplay, admin);

        logoutMenuOption.performOperation();

        assertEquals("Logout unsuccessful\n", outContent.toString());
    }
}
