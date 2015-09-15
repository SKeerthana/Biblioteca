package com.thoughtworks.biblioteca;

public class CheckOutMoviesMenuOption implements MenuOption {
    private Biblioteca movieLibraryData;
    private Display display;

    public CheckOutMoviesMenuOption(Biblioteca movieLibraryData, Display display) {
        this.movieLibraryData = movieLibraryData;
        this.display = display;
    }

    @Override
    public void performOperation() {
        String movieName = display.getInputFromUser();
        Movie movieTobeSearched = new Movie(movieName, 0, null, 0);
        if (movieLibraryData.containsLibraryItemInAvailableList(movieTobeSearched)) {
            movieLibraryData.checkOutLibraryItem(movieTobeSearched);
        }
    }
}
