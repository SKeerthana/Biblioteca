package com.thoughtworks.biblioteca;

public class CheckOutMoviesMenuOption implements MenuOption {
    private Biblioteca movieLibraryData;
    private ConsoleDisplay consoleDisplay;

    public CheckOutMoviesMenuOption(Biblioteca movieLibraryData, ConsoleDisplay consoleDisplay) {
        this.movieLibraryData = movieLibraryData;
        this.consoleDisplay = consoleDisplay;
    }

    @Override
    public void performOperation() {
        String movieName = consoleDisplay.getInputFromUser();
        Movie movieTobeSearched = new Movie(movieName, 0, null, 0);
        if (movieLibraryData.containsLibraryItemInAvailableList(movieTobeSearched)) {
            movieLibraryData.checkOutLibraryItem(movieTobeSearched);
        }
    }
}
