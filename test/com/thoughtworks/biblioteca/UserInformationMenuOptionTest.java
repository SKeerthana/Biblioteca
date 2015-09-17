package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UserInformationMenuOptionTest {
    @Test
    public void shouldDisplayFormattedUserInformation() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outContent);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(printStream, System.in);
        User currentUser = new User("lib-0001", "abc", "abc", "abc@gmail.com", "9944172304", new LoggedInUserRole());
        UserView userView = new UserView(currentUser);
        UserInformationMenuOption userInformationMenuOption = new UserInformationMenuOption(userView, consoleDisplay);

        userInformationMenuOption.performOperation();

        assertEquals(userView.getFormattedUserDetails(), outContent.toString());
    }
}
