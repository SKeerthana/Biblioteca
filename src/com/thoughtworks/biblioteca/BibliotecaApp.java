package com.thoughtworks.biblioteca;

import java.util.ArrayList;

//displays the welcome message and menu options
public class BibliotecaApp {
    private Display display;
    private Menu menu;

    public static void main(String[] args) {
        ArrayList<String> listOfMenuOptions = new ArrayList<String>();
        listOfMenuOptions.add("1. List all the books");
        listOfMenuOptions.add("2. Quit");
        listOfMenuOptions.add("3. Checkout books");
        listOfMenuOptions.add("4. Return books");

        Menu menu = new Menu(listOfMenuOptions);
        Display display = new Display(System.out, System.in);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu, display);

        bibliotecaApp.start();
    }

    public BibliotecaApp(Menu menu, Display display) {
        this.menu = menu;
        this.display = display;
    }

    public void start() {
        ArrayList<LibraryItem> listOfAvailableBooks = generateListOfBooks();
        ArrayList<LibraryItem> listOfMoviesAvailable = generateListOfMovies();
        Biblioteca bookLibraryData = new Biblioteca(listOfAvailableBooks, new ArrayList<LibraryItem>());
        Biblioteca movieLibraryData = new Biblioteca(listOfAvailableBooks, new ArrayList<LibraryItem>());
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, display);

        display.printMessage("Welcome to Bibliotica\n");

        while (true) {
            menuOptionController.displayMenuOption();
            String option = display.getInputFromUser();
            menuOptionController.handleMenuOption(option);
        }
    }

    private ArrayList<LibraryItem> generateListOfMovies() {
        return null;
    }

    private ArrayList<LibraryItem> generateListOfBooks() {
        Book book1 = new Book("My experiments with Truth", "M.K.Gandhi", 1942);
        Book book2 = new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998);
        ArrayList<LibraryItem> listOfBooks = new ArrayList<>();
        listOfBooks.add(book1);
        listOfBooks.add(book2);
        return listOfBooks;
    }
}
