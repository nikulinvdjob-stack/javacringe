package ru.alfabank.hw.hw12;

import java.util.ArrayList;
import java.util.List;

public class App {
    static void main() throws FlightNotFoundException, BaggageTagPrintException {

        List<String> flights = new ArrayList<>();

        flights.add("SU-123");
        flights.add("TU-777");
        flights.add("KC-909");
        flights.add("AE-404");

        BaggageDropDesk baggageDropDesk = new BaggageDropDesk(flights);

        try {
            System.out.println(
                    baggageDropDesk.CheckBaggage(
                            "Успешный пассажир",
                            "SU-123",
                            21.34f).toString());
        } catch (AirportServiceException e) {
            System.err.println("Ошибка сервиса: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }

        try {
            System.out.println(
                    baggageDropDesk.CheckBaggage(
                            "Пассажир с несуществующим рейсом",
                            "DEBIK-67",
                            21.34f).toString());
        } catch (AirportServiceException e) {
            System.err.println("Ошибка сервиса: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }

        try {
            System.out.println(
                    baggageDropDesk.CheckBaggage(
                            "Пассажир с тяжелым багажом",
                            "TU-777",
                            23.01f).toString());
        } catch (AirportServiceException e) {
            System.err.println("Ошибка сервиса: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }

        try {

            System.out.println(
                    baggageDropDesk.CheckBaggage(
                            "Пассажир с дешевым принтером",
                            "AE-404",
                            21.01f).toString());
        } catch (AirportServiceException e) {
            System.err.println("Ошибка сервиса: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }

        try {
            System.out.println(
                    baggageDropDesk.CheckBaggage(
                            "",
                            "KC-909",
                            21.01f).toString());
        } catch (AirportServiceException e) {
            System.err.println("Ошибка сервиса: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }

        try {
            System.out.println(
                    baggageDropDesk.CheckBaggage(
                            null,
                            "KC-909",
                            21.01f).toString());
        } catch (AirportServiceException e) {
            System.err.println("Ошибка сервиса: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }

        try {
            System.out.println(
                    baggageDropDesk.CheckBaggage(
                            "Пассажир с отрицательным весом багажа",
                            "KC-909",
                            -1.01f).toString());
        } catch (AirportServiceException e) {
            System.err.println("Ошибка сервиса: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Ошибка валидации: " + e.getMessage());
        }
    }
}
