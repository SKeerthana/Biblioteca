package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoleTest {

    @Test
    public void shouldReturnAdminOptionsWhenAdminValueIsSet() {
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
        assertEquals(menuList, new AdminRole().getMenuOptions());
    }

    @Test
    public void shouldReturnUserOptionsWhenUserValueIsSet() {
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
        assertEquals(menuList, new LoggedInUserRole().getMenuOptions());
    }

    @Test
    public void shouldReturnGuestOptionsWhenGuestIsSet() {
        ArrayList<String> menuList = new ArrayList<String>() {{
            add("List Books");
            add("Quit");
            add("CheckOut Book");
            add("Return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("Log in");
        }};
        assertEquals(menuList, new GuestRole().getMenuOptions());
    }
}
