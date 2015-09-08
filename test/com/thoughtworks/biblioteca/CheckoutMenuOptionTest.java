package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertFalse;

public class CheckoutMenuOptionTest {
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<Book> listOfBooks = new ArrayList<Book>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks);

    @Test
    public void shouldCheckoutBook() {
        String input = "Harry Potter and the Chamber of Secrets";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        Display display = new Display(System.out, inContent);
        Book bookToSearch = new Book(input, null, 0);
        System.setIn(inContent);
        CheckoutMenuOption checkoutMenuOption = new CheckoutMenuOption(bibilioteca,display);

        checkoutMenuOption.performOperation();

        assertFalse(bibilioteca.contains(bookToSearch));
    }
}
