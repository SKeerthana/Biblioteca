package com.thoughtworks.biblioteca.options;

import org.junit.Test;
import com.thoughtworks.biblioteca.view.*;
import com.thoughtworks.biblioteca.user.*;

import static org.mockito.Mockito.*;

public class LoginMenuOptionTest {

    @Test
    public void shouldDisplayLoginSuccessfulForLoggedInUser() {
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        User loggedInUser = new User("1234-122", "abc", "abc", "abc@gmail.com", "9944172304", new LoggedInUserRole());
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleDisplay, loggedInUser);
        doNothing().when(consoleDisplay).printMessage("Login successful\n");

        loginMenuOption.performOperation();

        verify(consoleDisplay, times(1)).printMessage("Login successful\n");
    }

    @Test
    public void shouldDisplayLoginUnSuccessfulForGuestUser() {
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        User guestUser = new User("1234-122", "abc", "abc", "abc@gmail.com", "9944172304", new GuestRole());
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleDisplay, guestUser);
        doNothing().when(consoleDisplay).printMessage("Login unsuccessful\n");

        loginMenuOption.performOperation();

        verify(consoleDisplay, times(1)).printMessage("Login unsuccessful\n");
    }

    @Test
    public void shouldDisplayLoginUnSuccessfulForAdmin() {
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        User admin = new User("1234-122", "abc", "abc", "abc@gmail.com", "9944172304", new AdminRole());
        LoginMenuOption loginMenuOption = new LoginMenuOption(consoleDisplay, admin);
        doNothing().when(consoleDisplay).printMessage("Login successful\n");

        loginMenuOption.performOperation();

        verify(consoleDisplay, times(1)).printMessage("Login successful\n");
    }
}