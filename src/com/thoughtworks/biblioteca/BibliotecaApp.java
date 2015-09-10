package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//displays the welcome message and menu options
public class BibliotecaApp {
    private Display display;
    private Menu menu;

    public static void main(String[] args) {
        Menu menu = new Menu();
        Display display = new Display(System.out, System.in);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu, display);
        bibliotecaApp.start();
    }

    public BibliotecaApp(Menu menu, Display display) {
        this.menu = menu;
        this.display = display;
    }

    public void start() {
        ArrayList<Book> listOfAvailableBooks = generateListOfBooks();
        Biblioteca biblioteca = new Biblioteca(listOfAvailableBooks, new ArrayList<Book>());
        MenuOptionController menuOptionController = new MenuOptionController(menu, biblioteca, display);

        display.printMessage("Welcome to Bibliotica\n");

        while (true) {
            menuOptionController.displayMenuOption();
            String option = display.getInputFromUser();
            menuOptionController.handleMenuOption(option);
        }
    }

    private ArrayList<Book> generateListOfBooks() {
        Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
        ArrayList<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        return listOfBooks;
    }
}
