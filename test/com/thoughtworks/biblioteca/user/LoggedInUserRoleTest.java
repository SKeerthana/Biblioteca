package com.thoughtworks.biblioteca.user;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoggedInUserRoleTest {
    private LoggedInUserRole loggedInUserRole = new LoggedInUserRole();

    @Test
    public void shouldReturnListOfMenuOptions() {
        ArrayList<String> menuList = new ArrayList<String>() {{
            add("List Books");
            add("Quit");
            add("CheckOut Book");
            add("Return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("User Information");
            add("Log out");
        }};
        assertEquals(menuList, loggedInUserRole.getMenuOptions());
    }

    @Test
    public void shouldReturnTrueForCheckedBookAllowed() {
        assertTrue(loggedInUserRole.isAuthenticatedUser());
    }
}
