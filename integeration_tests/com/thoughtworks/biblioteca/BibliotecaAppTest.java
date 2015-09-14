package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class BibliotecaAppTest {

    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<Book> listOfBooks = new ArrayList<Book>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<Book>());
    BibliotecaView bibliotecaView = new BibliotecaView(bibilioteca);
    Menu menu = new Menu();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldDisplayListOfBooksOptionsAfterDisplayingWelcomeMessage() {
        Display display = mock(Display.class);
        when(display.getInputFromUser()).thenReturn("1", "2");
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu, display);
        MenuOptionController menuOptionController = mock(MenuOptionController.class);
        ListBooksMenuOption listBooksMenuOption = new ListBooksMenuOption(bibliotecaView, display);
        when(menuOptionController.getMenuOption("1")).thenReturn(listBooksMenuOption);
        exit.expectSystemExit();

        bibliotecaApp.start();

        verify(listBooksMenuOption, times(1)).performOperation();
    }
}
