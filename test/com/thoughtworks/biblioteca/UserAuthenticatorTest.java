package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserAuthenticatorTest {

    @Test
    public void shouldLoginForValidCredentials() {
        final User user1 = new User("abc", "abc", "abc", "", Role.ADMIN);
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", user1);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertTrue(userAuthenticator.authenticate("1234-122", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidLibraryNumber() {
        final User user1 = new User("abc", "abc", "abc", "", Role.ADMIN);
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", user1);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertFalse(userAuthenticator.authenticate("1234-123", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidPassword() {
        final User user1 = new User("abc", "abc", "abc", "", Role.ADMIN);
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", user1);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertFalse(userAuthenticator.authenticate("1234-123", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidCredentials() {
        final User user1 = new User("abc", "abc", "abc", "", Role.ADMIN);
        HashMap<String, User> validUsers = new HashMap<String, User>() {{
            put("1234-122", user1);
        }};
        UserAuthenticator userAuthenticator = new UserAuthenticator(validUsers);

        assertFalse(userAuthenticator.authenticate("1234-123", "abasd"));
    }
}
