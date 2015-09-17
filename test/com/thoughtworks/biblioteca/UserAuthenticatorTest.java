package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserAuthenticatorTest {
    private User currentUser = new User("abc", "abc", "abc", "", new AdminRole());

    @Test
    public void shouldLoginForValidCredentials() {
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertTrue(userAuthenticator.authenticate("1234-122", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidLibraryNumber() {
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertFalse(userAuthenticator.authenticate("1234-123", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidPassword() {
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertFalse(userAuthenticator.authenticate("1234-123", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidCredentials() {
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", currentUser);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertFalse(userAuthenticator.authenticate("1234-123", "abasd"));
    }
}
