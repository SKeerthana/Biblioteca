package com.thoughtworks.biblioteca.user;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AdminRoleTest {
    private AdminRole adminRole = new AdminRole();

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
            add("Book Status");
            add("Log out");
        }};
        assertEquals(menuList, adminRole.getMenuOptions());
    }

    @Test
    public void shouldReturnTrueForCheckedBookAllowed() {
        assertTrue(adminRole.isAuthenticatedUser());
    }
}
