package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    @Test
    public void shouldReturnTheListOFMenuOptions() {
        Menu menu = new Menu();
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "1. List all the books\n";
        menuOptions += "2. Quit\n";
        menuOptions += "3. Checkout books\n";
        assertEquals(menuOptions, menu.getMenuOptions());
    }

    @Test
    public void shouldHandleListOfBooksOption() {
        ListBooksMenuOption listBooksMenuOption = mock(ListBooksMenuOption.class);
        Menu menu = new Menu();
        menu.handleSelectedMenuOption(listBooksMenuOption);
        verify(listBooksMenuOption).performOperation();
    }
}
