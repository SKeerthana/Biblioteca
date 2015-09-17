package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

//displays the welcome message and menu options
public class BibliotecaApp {
    private ConsoleDisplay consoleDisplay;
    private Menu menu;

    public static void main(String[] args) {
        ArrayList<String> listOfMenuOptions = new ArrayList<String>();
        listOfMenuOptions.add("1. List all the books");
        listOfMenuOptions.add("2. Quit");
        listOfMenuOptions.add("3. Checkout books");
        listOfMenuOptions.add("4. Return books");
        listOfMenuOptions.add("5. List all the movies");
        listOfMenuOptions.add("6. Checkout movies");

        Menu menu = new Menu(listOfMenuOptions);
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.out, System.in);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(menu, consoleDisplay);

        bibliotecaApp.start();
    }

    public BibliotecaApp(Menu menu, ConsoleDisplay consoleDisplay) {
        this.menu = menu;
        this.consoleDisplay = consoleDisplay;
    }

    public void start() {
        ArrayList<LibraryItem> listOfAvailableBooks = generateListOfBooks();
        ArrayList<LibraryItem> listOfMoviesAvailable = generateListOfMovies();
        HashMap<String, User> listOfUsers = generateListOfValidUsers();
        Biblioteca bookLibraryData = new Biblioteca(listOfAvailableBooks, new ArrayList<LibraryItem>());
        Biblioteca movieLibraryData = new Biblioteca(listOfMoviesAvailable, new ArrayList<LibraryItem>());
        UserAuthenticator userAuthenticator = new UserAuthenticator(listOfUsers);
        MenuOptionController menuOptionController = new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator);

        consoleDisplay.printMessage("Welcome to Bibliotica\n");

        while (true) {
            menuOptionController.displayMenuOption();
            String option = consoleDisplay.getInputFromUser();
            menuOptionController.handleMenuOption(option);
        }
    }

    private HashMap<String, User> generateListOfValidUsers() {
        HashMap<String, User> userInfos = new HashMap<>();
        User normalUser = new User("lib-0001", "name", "abc", "abc@gmail.com", new LoggedInUserRole());
        User admin = new User("lib-0002", "name", "abc", "abc@gmail.com", new LoggedInUserRole());
        userInfos.put("lib-0001", normalUser);
        userInfos.put("lib-0002", admin);
        return userInfos;
    }

    private ArrayList<LibraryItem> generateListOfMovies() {
        Movie movie1 = new Movie("Vishvaroopam", 2013, "Kamalhasan", 10);
        Movie movie2 = new Movie("The Dark Knight Returns", 2013, "Frank Miller", 10);
        ArrayList<LibraryItem> availableMovieList = new ArrayList<>();
        availableMovieList.add(movie1);
        availableMovieList.add(movie2);
        return availableMovieList;
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
