package com.thoughtworks.biblioteca.options;

import org.junit.Test;
import com.thoughtworks.biblioteca.view.*;
import com.thoughtworks.biblioteca.user.*;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LogoutMenuOptionTest {
    @Test
    public void shouldDisplayLogOutUnSuccessfulForLoggedInUser() {
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        User loggedInUser = new User("1234-122", "abc", "abc", "abc@gmail.com", "9944172304", new LoggedInUserRole());
        LogoutMenuOption logoutMenuOption = new LogoutMenuOption(consoleDisplay, loggedInUser);
        doNothing().when(consoleDisplay).printMessage("Logout unsuccessful\n");

        logoutMenuOption.performOperation();

        verify(consoleDisplay, times(1)).printMessage("Logout unsuccessful\n");
    }

    @Test
    public void shouldDisplayLogOutSuccessfulForGuestUser() {
        ConsoleDisplay consoleDisplay = mock(ConsoleDisplay.class);
        User guestUser = new User("1234-122", "abc", "abc", "abc@gmail.com", "9944172304", new GuestRole());
        LogoutMenuOption logoutMenuOption = new LogoutMenuOption(consoleDisplay, guestUser);
        doNothing().when(consoleDisplay).printMessage("Logout successful\n");

        logoutMenuOption.performOperation();

        verify(consoleDisplay, times(1)).printMessage("Logout successful\n");
    }
}
