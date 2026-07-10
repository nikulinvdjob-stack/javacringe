package ru.alfabank.hw.hw13;

import java.util.Objects;

import static java.lang.Math.clamp;

public class Alien {
    private String name;
    private String planet;
    private int dangerLevel;

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Alien alien)) return false;
        return Objects.equals(name, alien.name) && Objects.equals(planet, alien.planet);
    }

    public Alien(String name, String planet, int dangerLevel) {
        this.name = name;
        this.planet = planet;
        this.dangerLevel = clamp(dangerLevel, 1, 10);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet);
    }

    @Override
    public String toString() {
        return "Alien{" +
                "name='" + name + '\'' +
                ", planet='" + planet + '\'' +
                ", dangerLevel=" + dangerLevel +
                '}';
    }
}
