package ru.alfabank.hw.hw12;

import java.util.ArrayList;
import java.util.List;

public class App {

    private static String simpleExceptionHandler(BaggageDropDesk baggageDropDesk, String name, String flight, int weight) {
        try {
            return baggageDropDesk.CheckBaggage(name, flight, weight).toString();
        } catch (FlightNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (BaggageTagPrintException e) {
            System.err.println(e.getMessage());
        } catch (OverweightBaggageException e) {
            System.err.println(e.getMessage());
        } catch (InvalidPassengerNameException e) {
            System.err.println(e.getMessage());
        } catch (InvalidBaggageWeightException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private static String coolExceptionHandler(BaggageDropDesk baggageDropDesk, String name, String flight, int weight) {
        try {
            return baggageDropDesk.CheckBaggage(name, flight, weight).toString();
        } catch (AirportServiceException e) {
            System.err.println(e.getMessage());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    static void main() {

        List<String> flights = new ArrayList<>();

        flights.add("SU-123");
        flights.add("TU-777");
        flights.add("KC-909");
        flights.add("AE-404");

        BaggageDropDesk baggageDropDesk = new BaggageDropDesk(flights);

        System.out.println(simpleExceptionHandler(baggageDropDesk, "Успешный пассажир", "SU-123", 21));
        System.out.println(simpleExceptionHandler(baggageDropDesk, "Пассажир с несуществующим рейсом", "DEBIK-67", 21));

        System.out.println(coolExceptionHandler(baggageDropDesk, "Пассажир с тяжелым багажом", "TU-777",24));
        System.out.println(coolExceptionHandler(baggageDropDesk,"Пассажир с дешевым принтером", "AE-404", 21));
        System.out.println(coolExceptionHandler(baggageDropDesk,"","KC-909",21));
        System.out.println(coolExceptionHandler(baggageDropDesk,null,"KC-909",21));
        System.out.println(coolExceptionHandler(baggageDropDesk,"Пассажир с отрицательным весом багажа","KC-909",-1));
    }
}
