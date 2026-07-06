package ru.alfabank.hw.hw12;

import ru.alfabank.hw.hw12.exceptions.*;

import java.util.List;

public class BaggageDropDesk {
    private List<String> availableFlights;

    public BaggageDropDesk(List<String> availableFlights) {
        this.availableFlights = availableFlights;
    }

    public BaggageTicket CheckBaggage(String passengerName, String flightNumber, int baggageWeight) throws OverweightBaggageException, FlightNotFoundException, BaggageTagPrintException {

        if (passengerName == null || passengerName.isEmpty())
            throw new InvalidPassengerNameException("Женя? Вы же девочка, что вы меня за дурака держите. Имя некорретное - исправьте!");

        if (baggageWeight < 0)
            throw new InvalidBaggageWeightException("Провоз антиматерии на борт летного судна запрещен");

        if (baggageWeight > 23)
            throw new OverweightBaggageException("Кирпичи везем?");

        if (!availableFlights.contains(flightNumber))
            throw new FlightNotFoundException("Вас нет в списке первого класса. Миранда Пристли числится в эконом рейсе");

        if (flightNumber.equals("AE-404"))
            throw new BaggageTagPrintException("Купи принтер дороже трехсот рублей");

        System.out.println("Все правильно. Налог.");

        return new BaggageTicket(passengerName, flightNumber, baggageWeight);
    }
}
