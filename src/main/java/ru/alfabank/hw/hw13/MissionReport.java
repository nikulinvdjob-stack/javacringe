package ru.alfabank.hw.hw13;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MissionReport {
    private String missionName;
    private List<Alien> captureAliens = new ArrayList<>();
    int squadSize;

    public MissionReport(String missionName, List<Alien> captureAliens, int squadSize) {
        this.missionName = missionName;
        this.captureAliens = captureAliens;
        this.squadSize = squadSize;
    }

    @Override
    public String toString() {
        return "MissionReport{" +
                "Миссия: '" + missionName + '\'' +
                ", Поймано чекушек: " + captureAliens.size() +
                ", Размер отряда: " + squadSize +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof MissionReport that)) return false;
        return squadSize == that.squadSize && Objects.equals(missionName, that.missionName) && Objects.equals(captureAliens, that.captureAliens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(missionName, captureAliens, squadSize);
    }
}
