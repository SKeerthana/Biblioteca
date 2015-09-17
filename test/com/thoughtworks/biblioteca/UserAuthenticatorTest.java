package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class UserAuthenticatorTest {
    private User currentUser = new User("1234-122", "abc", "abc", "", "9944172304", new AdminRole());
    private User guestUser = new User("guest-001", "", "", "", "9944172304", new GuestRole());

    @Test
    public void shouldLoginForValidCredentials() {
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertEquals(currentUser, userAuthenticator.authenticate("1234-122", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidLibraryNumber() {
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertEquals(guestUser, userAuthenticator.authenticate("1234-123", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidPassword() {
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertEquals(guestUser, userAuthenticator.authenticate("1234-122", "abc122"));
    }

    @Test
    public void shouldNotLoginForInValidCredentials() {
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertEquals(guestUser, userAuthenticator.authenticate("12234-122", "abc122"));
    }

    @Test
    public void shouldReturnLoggedInUserForValidUser() {
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", currentUser);
        }};
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        System.setOut(printStream);
        String input = "1234-122" + "\n" + "abc";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.out, System.in);
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertEquals(currentUser, userAuthenticator.loginUser(consoleDisplay));
    }
}
