package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void shouldReturnTheListOFMenuOptions() {
        Menu menu = new Menu();
        String menuOptions = "Menu options :\n";
        menuOptions += "List all the books\n";
        assertEquals(menuOptions, menu.getMenuOptions());
    }
}
