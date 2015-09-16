package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RoleTest {
    @Test
    public void shouldReturnDefaultOptionsWhenAdminValueIsSet() {
        ArrayList<String> menuList = new ArrayList<String>() {{
            add("List Books");
            add("Quit");
            add("CheckOut Book");
            add("Return Book");
            add("List Movies");
            add("CheckOut Movie");
            add("Log in");
        }};
        Role role = Role.ADMIN;
        assertEquals(menuList, role.getMenuOptions());
    }
}
