package com.thoughtworks.biblioteca.options;

import com.thoughtworks.biblioteca.model.*;
import com.thoughtworks.biblioteca.view.*;

public class CheckOutMoviesMenuOption implements MenuOption {
    private Library movieLibraryData;
    private ConsoleDisplay consoleDisplay;
    private final int UNKNOWN_YEAR_RELEASED = 0;
    private final int UNKNOWN_RATING = 0;
    private final String UNKNOWN_DIRECTOR = null;

    public CheckOutMoviesMenuOption(Library movieLibraryData, ConsoleDisplay consoleDisplay) {
        this.movieLibraryData = movieLibraryData;
        this.consoleDisplay = consoleDisplay;
    }

    @Override
    public void performOperation() {
        String movieName = consoleDisplay.getInputFromUser();
        Movie movieTobeSearched = new Movie(movieName, UNKNOWN_YEAR_RELEASED, UNKNOWN_DIRECTOR, UNKNOWN_RATING);
        int index = movieLibraryData.getIndexOfLibraryItemInAvailableList(movieTobeSearched);
        if (index != -1) {
            LibraryItem movie = movieLibraryData.removeLibraryItemFromAvailableList(index);
            movieLibraryData.addLibraryItemToCheckedOutList(movie);
            consoleDisplay.printMessage("Thank you! Enjoy the Movie\n");
        }
    }
}
