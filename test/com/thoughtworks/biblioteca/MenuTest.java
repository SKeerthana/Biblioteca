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
    public void shouldReturnTheListOfMenuOptionsForGuestUsers() {
        Menu menu = new Menu(listOfMenuOptions);
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "List Books\n";
        menuOptions += "Quit\n";
        menuOptions += "CheckOut Book\n";
        menuOptions += "Return Book\n";
        menuOptions += "List Movies\n";
        menuOptions += "CheckOut Movie\n";
        menuOptions += "Log in\n";
        assertEquals(menuOptions, menu.getMenuOptions(new UserInfo("lib-0001", "name", "abc", "abc@gmail.com", Role.GUEST)));
    }

    @Test
    public void shouldReturnTheListOfMenuOptionsForNormalUsers() {
        Menu menu = new Menu(listOfMenuOptions);
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "List Books\n";
        menuOptions += "Quit\n";
        menuOptions += "CheckOut Book\n";
        menuOptions += "Return Book\n";
        menuOptions += "List Movies\n";
        menuOptions += "CheckOut Movie\n";
        menuOptions += "User Information\n";
        menuOptions += "Log out\n";
        assertEquals(menuOptions, menu.getMenuOptions(new UserInfo("lib-0001", "name", "abc", "abc@gmail.com", Role.USER)));
    }

    @Test
    public void shouldHandleListOfBooksOption() {
        ListLibraryItemMenuOption listLibraryItemMenuOption = mock(ListLibraryItemMenuOption.class);
        Menu menu = new Menu(listOfMenuOptions);
        menu.handleSelectedMenuOption(listLibraryItemMenuOption);
        verify(listLibraryItemMenuOption).performOperation();
    }
}
