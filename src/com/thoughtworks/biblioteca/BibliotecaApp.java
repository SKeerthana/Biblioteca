package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

//displays the welcome message and menu options
public class BibliotecaApp {
    private ConsoleDisplay consoleDisplay;

    public static void main(String[] args) {
        ConsoleDisplay consoleDisplay = new ConsoleDisplay(System.out, System.in);
        BibliotecaApp bibliotecaApp = new BibliotecaApp(consoleDisplay);
        bibliotecaApp.start();
    }

    public BibliotecaApp(ConsoleDisplay consoleDisplay) {
        this.consoleDisplay = consoleDisplay;
    }

    public void start() {
        MenuOptionController menuOptionController = getMenuOptionController();
        consoleDisplay.printMessage("Welcome to Bibliotica\n");

        while (true) {
            run(menuOptionController);
        }
    }

    public void run(MenuOptionController menuOptionController) {
        menuOptionController.displayMenuOption();
        String option = consoleDisplay.getInputFromUser();
        menuOptionController.handleMenuOption(option);
    }

    private MenuOptionController getMenuOptionController() {
        ArrayList<LibraryItem> listOfAvailableBooks = generateListOfBooks();
        ArrayList<LibraryItem> listOfMoviesAvailable = generateListOfMovies();
        ArrayList<User> listOfUsers = generateListOfValidUsers();

        Biblioteca bookLibraryData = new Biblioteca(listOfAvailableBooks, new ArrayList<LibraryItem>());
        Biblioteca movieLibraryData = new Biblioteca(listOfMoviesAvailable, new ArrayList<LibraryItem>());
        UserAuthenticator userAuthenticator = new UserAuthenticator(listOfUsers);

        User guestUser = new User("guest-001", "", "", "", "", new GuestRole());
        Menu menu = new Menu(guestUser.getMenuOptions());

        return new MenuOptionController(menu, bookLibraryData, movieLibraryData, consoleDisplay, userAuthenticator, guestUser);
    }

    private ArrayList<User> generateListOfValidUsers() {
        ArrayList<User> userInfos = new ArrayList<>();
        User normalUser = new User("lib-0001", "name", "abc", "abc@gmail.com", "9944172304", new LoggedInUserRole());
        User admin = new User("lib-0002", "name", "abc", "abc@gmail.com", "9944172304", new AdminRole());
        userInfos.add(normalUser);
        userInfos.add(admin);

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
