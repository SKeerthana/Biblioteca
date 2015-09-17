package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class GuestRoleTest {
    private GuestRole guestRole = new GuestRole();

    @Test
    public void shouldReturnListOfMenuOptions() {
        ArrayList<String> menuList = new ArrayList<String>() {{
            add("List Books");
            add("Quit");
            add("CheckOut Book");
            add("Return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("Log in");
        }};
        assertEquals(menuList, guestRole.getMenuOptions());
    }

    @Test
    public void shouldReturnFalseForCheckedBookAllowed() {
        assertFalse(guestRole.isAuthenticatedUser());
    }
}
