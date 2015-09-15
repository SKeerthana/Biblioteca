package com.thoughtworks.biblioteca;

public class Movie implements LibraryItem{
    private String movieName;
    private int yearReleased;
    private String director;
    private int ratings;

    public Movie(String movieName, int yearPublished, String director, int ratings) {
        this.ratings = ratings;
        this.movieName = movieName;
        this.yearReleased = yearPublished;
        this.director = director;
    }

    @Override
    public String[] getHeaderDetails() {
        String[] movieHeaderInfo = new String[4];
        movieHeaderInfo[0] = "MOVIE NAME";
        movieHeaderInfo[1] = "DIRECTOR";
        movieHeaderInfo[2] = "YEAR";
        movieHeaderInfo[3] = "RATINGS";
        return movieHeaderInfo;
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

    public String getMovieName() {
        return movieName;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public String getDirector() {
        return director;
    }

    public int getRatings() {
        return ratings;
    }
}
