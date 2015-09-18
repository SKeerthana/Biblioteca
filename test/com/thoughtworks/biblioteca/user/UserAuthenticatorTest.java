package com.thoughtworks.biblioteca.user;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import com.thoughtworks.biblioteca.view.*;

import static org.junit.Assert.assertEquals;

public class UserAuthenticatorTest {
    private User currentUser = new User("1234-122", "abc", "abc", "", "9944172304", new AdminRole());
    private User guestUser = new User("guest-001", "", "", "", "9944172304", new GuestRole());

    @Test
    public void shouldLoginForValidCredentials() {
        ArrayList<User> validUsers = new ArrayList<User>() {{
            add(currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertEquals(currentUser, userAuthenticator.authenticate("1234-122", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidLibraryNumber() {
        ArrayList<User> validUsers = new ArrayList<User>() {{
            add(currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertEquals(guestUser, userAuthenticator.authenticate("1234-123", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidPassword() {
        ArrayList<User> validUsers = new ArrayList<User>() {{
            add(currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertEquals(guestUser, userAuthenticator.authenticate("1234-122", "abc122"));
    }

    @Test
    public void shouldNotLoginForInValidCredentials() {
        ArrayList<User> validUsers = new ArrayList<User>() {{
            add(currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertEquals(guestUser, userAuthenticator.authenticate("12234-122", "abc122"));
    }

    @Test
    public void shouldReturnLoggedInUserForValidUser() {
        ArrayList<User> validUsers = new ArrayList<User>() {{
            add(currentUser);
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
