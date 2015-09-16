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
        Role role = Role.ADMIN;
        assertEquals(menuList, role.getMenuOptions());
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
        Role role = Role.USER;
        assertEquals(menuList, role.getMenuOptions());
    }
}
