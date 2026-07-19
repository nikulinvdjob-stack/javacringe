package ru.alfabank.hw.hw14.Movie;

import java.util.Comparator;

public class MovieRatingComparator implements Comparator<Movie> {

    @Override
    public int compare(Movie o1, Movie o2) {
        return Double.compare(o1.getRate(), o2.getRate());
    }

}
