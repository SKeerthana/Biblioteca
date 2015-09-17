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
        assertEquals(menuOptions, menu.getMenuOptionsToDisplay(new User("lib-0001", "name", "abc", "abc@gmail.com", new GuestRole())));
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
        assertEquals(menuOptions, menu.getMenuOptionsToDisplay(new User("lib-0001", "name", "abc", "abc@gmail.com", new LoggedInUserRole())));
    }

    @Test
    public void shouldReturnTheListOfMenuOptionsForAdmin() {
        Menu menu = new Menu(listOfMenuOptions);
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "List Books\n";
        menuOptions += "Quit\n";
        menuOptions += "CheckOut Book\n";
        menuOptions += "Return Book\n";
        menuOptions += "List Movies\n";
        menuOptions += "CheckOut Movie\n";
        menuOptions += "User Information\n";
        menuOptions += "Book Status\n";
        menuOptions += "Log out\n";
        assertEquals(menuOptions, menu.getMenuOptionsToDisplay(new User("lib-0001", "name", "abc", "abc@gmail.com", new AdminRole())));
    }

    @Test
    public void shouldHandleListOfBooksOption() {
        ListLibraryItemMenuOption listLibraryItemMenuOption = mock(ListLibraryItemMenuOption.class);
        Menu menu = new Menu(listOfMenuOptions);
        menu.handleSelectedMenuOption(listLibraryItemMenuOption);
        verify(listLibraryItemMenuOption).performOperation();
    }
}
