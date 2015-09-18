package com.thoughtworks.biblioteca;

import java.util.List;

public class MovieView implements LibraryView {
    private Library movieDataLibrary;

    public MovieView(Library movieDataLibrary) {
        this.movieDataLibrary = movieDataLibrary;
    }

    public String getFormattedListOfItems() {
        List<LibraryItem> availableMovies = movieDataLibrary.getAvailableItems();
        String movieHeader = "=====================================================================================\n";
        movieHeader += getItemDetailsHeader(availableMovies.get(0));
        movieHeader += "=====================================================================================\n";
        String movieDetails = getItemDetails(availableMovies);
        String movieFooter = "=====================================================================================\n";
        return movieHeader + movieDetails + movieFooter;
    }

    @Override
    public String getFormattedListOfCheckedOutItems() {
        return "Feature not supported";
    }

    private String getItemDetails(List<LibraryItem> movies) {
        String movieDetails = "";
        for (LibraryItem movieItem : movies) {
            Movie movie = (Movie) movieItem;
            movieDetails += String.format("%-25s %-25s %-15s %-15s\n", movie.getMovieName(), movie.getDirector(), movie.getYearReleased(), movie.getRatings());
        }
        return movieDetails;
    }

    private String getItemDetailsHeader(LibraryItem movie) {
        return String.format("%-25s %-25s %-15s %-15s\n", movie.getHeaderDetails());
    }
}