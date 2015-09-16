package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class UserManagerTest {

    @Test
    public void shouldLoginForValidCredentials() {
        final UserInfo userInfo1 = new UserInfo("abc", "abc", "abc", "", Role.ADMIN);
        HashMap<String, UserInfo> validUsers = new HashMap<String, UserInfo>() {{
            put("1234-122", userInfo1);
        }};
        UserManager userManager = new UserManager(validUsers);

        assertTrue(userManager.authenticate("1234-122", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidLibraryNumber() {
        final UserInfo userInfo1 = new UserInfo("abc", "abc", "abc", "", Role.ADMIN);
        HashMap<String, UserInfo> validUsers = new HashMap<String, UserInfo>() {{
            put("1234-122", userInfo1);
        }};
        UserManager userManager = new UserManager(validUsers);

        assertFalse(userManager.authenticate("1234-123", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidPassword() {
        final UserInfo userInfo1 = new UserInfo("abc", "abc", "abc", "", Role.ADMIN);
        HashMap<String, UserInfo> validUsers = new HashMap<String, UserInfo>() {{
            put("1234-122", userInfo1);
        }};
        UserManager userManager = new UserManager(validUsers);

        assertFalse(userManager.authenticate("1234-123", "abc"));
    }

    @Test
    public void shouldNotLoginForInValidCredentials() {
        final UserInfo userInfo1 = new UserInfo("abc", "abc", "abc", "", Role.ADMIN);
        HashMap<String, UserInfo> validUsers = new HashMap<String, UserInfo>() {{
            put("1234-122", userInfo1);
        }};
        UserManager userManager = new UserManager(validUsers);

        assertFalse(userManager.authenticate("1234-123", "abasd"));
    }
}
