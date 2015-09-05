package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MenuTest {

    @Test
    public void shouldReturnTheListOFMenuOptions() {
        Menu menu = new Menu();
        String menuOptions = "Menu options :\n";
        menuOptions += "1. List all the books\n";
        assertEquals(menuOptions, menu.getMenuOptions());
    }

    @Test
    public void shouldHandleTheSelectedOption() {
        Menu menu = new Menu();
        assertEquals(1,menu.handleSelectedMenuOption(1));
    }
}
