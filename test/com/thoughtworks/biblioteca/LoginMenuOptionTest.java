package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LoginMenuOptionTest {
    private User user1 = new User("1234-122", "abc", "abc", "abc@gmail.com", new AdminRole());
    HashMap<String, User> validUsers = new HashMap<String, User>() {{
        put("1234-122", user1);
    }};

    @Test
    public void shouldDisplayLoginSuccessfulForValidCredentials() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        String input = "1234-122" + "\n" + "abc";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleDisplay, userAuthenticator);

        loginMenuOption.performOperation();

        assertEquals("Enter Library Number : Enter Password : Login Successful\n", outContent.toString());
    }

    @Test
    public void shouldNotLoginForInValidCredentials() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        String input = "1234-122" + "\n" + "abc12";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleDisplay, userAuthenticator);

        loginMenuOption.performOperation();

        assertEquals("Enter Library Number : Enter Password : ", outContent.toString());
    }
}
