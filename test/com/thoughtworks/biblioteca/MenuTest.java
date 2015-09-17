package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    ArrayList<String> listOfMenuOptions = new ArrayList<String>();

    @Test
    public void shouldReturnTheListOfMenuOptionsForGuestUsers() {
        Menu menu = new Menu(listOfMenuOptions);
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "1.\tList Books\n";
        menuOptions += "2.\tQuit\n";
        menuOptions += "3.\tCheckOut Book\n";
        menuOptions += "4.\tReturn Book\n";
        menuOptions += "5.\tList Movies\n";
        menuOptions += "6.\tCheckOut Movie\n";
        menuOptions += "7.\tLog in\n";

        assertEquals(menuOptions, menu.getMenuOptionsToDisplay(new User("lib-0001", "name", "abc", "abc@gmail.com", new GuestRole())));
    }

    @Test
    public void shouldReturnTheListOfMenuOptionsForNormalUsers() {
        Menu menu = new Menu(listOfMenuOptions);
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "1.\tList Books\n";
        menuOptions += "2.\tQuit\n";
        menuOptions += "3.\tCheckOut Book\n";
        menuOptions += "4.\tReturn Book\n";
        menuOptions += "5.\tList Movies\n";
        menuOptions += "6.\tCheckOut Movie\n";
        menuOptions += "7.\tUser Information\n";
        menuOptions += "8.\tLog out\n";

        assertEquals(menuOptions, menu.getMenuOptionsToDisplay(new User("lib-0001", "name", "abc", "abc@gmail.com", new LoggedInUserRole())));
    }

    @Test
    public void shouldReturnTheListOfMenuOptionsForAdmin() {
        Menu menu = new Menu(listOfMenuOptions);
        String menuOptions = "Choose one of the menu option :\n";
        menuOptions += "1.\tList Books\n";
        menuOptions += "2.\tQuit\n";
        menuOptions += "3.\tCheckOut Book\n";
        menuOptions += "4.\tReturn Book\n";
        menuOptions += "5.\tList Movies\n";
        menuOptions += "6.\tCheckOut Movie\n";
        menuOptions += "7.\tUser Information\n";
        menuOptions += "8.\tBook Status\n";
        menuOptions += "9.\tLog out\n";

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
