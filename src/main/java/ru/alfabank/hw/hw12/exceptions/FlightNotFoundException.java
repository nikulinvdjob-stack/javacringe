package ru.alfabank.hw.hw12.exceptions;

public class FlightNotFoundException extends AirportServiceException {
    public FlightNotFoundException(String message) {
        super(message);
    }
}
