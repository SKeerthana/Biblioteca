package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LoggedInUserRoleTest {
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
        LoggedInUserRole loggedInUserRole = new LoggedInUserRole();
        assertEquals(menuList, loggedInUserRole.getMenuOptions());
    }
}
