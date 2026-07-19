package ru.alfabank.hw.hw14.Movie;

import java.util.ArrayList;
import java.util.List;

public class App {
    static void main() {
        List<Movie> movies = new ArrayList<>();

        movies.add(new Movie("Интерстеллар", 8.7f));
        movies.add(new Movie("Шрек", 8.1f));
        movies.add(new Movie("Начало", 8.8f));
        movies.add(new Movie("Веном", 6.6f));

        System.out.println("14.1");
        System.out.println(movies);
        movies.sort(new MovieRatingComparator());
        System.out.println(movies);

        System.out.println("14.2");
    }
}
