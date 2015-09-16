package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class LoginMenuOptionTest {
    private UserInfo userInfo1 = new UserInfo("abc", "abc", "abc");
    HashMap<String, UserInfo> validUsers = new HashMap<String, UserInfo>() {{
        put("1234-122", userInfo1);
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
        UserManager userManager = new UserManager(validUsers);

        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleDisplay, userManager);

        loginMenuOption.performOperation();

        assertEquals("Enter Library Number : Enter Password : Login Successful", outContent.toString());
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
        UserManager userManager = new UserManager(validUsers);

        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleDisplay, userManager);

        loginMenuOption.performOperation();

        assertEquals("Enter Library Number : Enter Password : ", outContent.toString());
    }
}
