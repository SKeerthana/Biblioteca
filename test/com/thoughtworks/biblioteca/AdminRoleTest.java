package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AdminRoleTest {
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
        AdminRole adminRole = new AdminRole();
        assertEquals(menuList, adminRole.getMenuOptions());
    }
}
