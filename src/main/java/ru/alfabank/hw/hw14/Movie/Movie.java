package ru.alfabank.hw.hw14.Movie;

public class Movie {
    private String label;

    public Movie(String label, float rate) {
        this.label = label;
        this.rate = rate;
    }

    private float rate;

    public float getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "label='" + label + '\'' +
                ", rate=" + rate +
                '}';
    }
}
