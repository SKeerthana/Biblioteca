package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

public class ReturnBookOptionTest {
    Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
    Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
    ArrayList<Book> listOfBooks = new ArrayList<Book>() {{
        add(book1);
        add(book2);
    }};
    Biblioteca bibilioteca = new Biblioteca(listOfBooks, new ArrayList<Book>());

    @Test
    public void shouldAddBookToAvailableListWhenItsReturned() {
        Display display = new Display(System.out, System.in);
        ReturnBookOption returnBookOption = new ReturnBookOption(bibilioteca, display);
        returnBookOption.performOperation();
    }
}
