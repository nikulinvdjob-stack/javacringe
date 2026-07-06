package ru.alfabank.hw.hw12;

public class BaggageTicket {
    private String passengerName;
    private String flightNumber;
    private float baggageWeight;

    public BaggageTicket(String passengerName, String flightNumber, float baggageWeight) {
        this.passengerName = passengerName;
        this.flightNumber = flightNumber;
        this.baggageWeight = baggageWeight;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public float getBaggageWeight() {
        return baggageWeight;
    }

    @Override
    public String toString() {
        return "BaggageTicket{" +
                "passengerName='" + passengerName + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", baggageWeight=" + baggageWeight +
                '}';
    }

}
