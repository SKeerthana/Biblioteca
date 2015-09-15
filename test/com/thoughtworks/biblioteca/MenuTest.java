package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    ArrayList<String> listOfMenuOptions = new ArrayList<String>() {{
        add("1. List all the books");
        add("2. Quit");
        add("3. Checkout books");
        add("4. Return books");
    }};

    @Test
    public void shouldReturnTheListOFMenuOptions() {
        Menu menu = new Menu(listOfMenuOptions);
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "1. List all the books\n";
        menuOptions += "2. Quit\n";
        menuOptions += "3. Checkout books\n";
        menuOptions += "4. Return books\n";
        assertEquals(menuOptions, menu.getMenuOptions());
    }

    @Test
    public void shouldHandleListOfBooksOption() {
        ListLibraryItemMenuOption listLibraryItemMenuOption = mock(ListLibraryItemMenuOption.class);
        Menu menu = new Menu(listOfMenuOptions);
        menu.handleSelectedMenuOption(listLibraryItemMenuOption);
        verify(listLibraryItemMenuOption).performOperation();
    }
}
