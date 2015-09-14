package com.thoughtworks.biblioteca;

public class Movie {
    private String movieName;
    private int yearPublished;
    private String director;
    private int unRated;

    public Movie(String movieName, int yearPublished, String director, int unRated) {
        this.unRated = unRated;
        this.movieName = movieName;
        this.yearPublished = yearPublished;
        this.director = director;
    }

    @Override
    public boolean equals(Object that) {
        if (that == this)
            return true;
        if (that == null || that.getClass() != getClass())
            return false;
        Movie thatMovie = (Movie) that;
        return thatMovie.movieName.equals(movieName);
    }

    @Override
    public int hashCode() {
        return movieName.hashCode();
    }
}
