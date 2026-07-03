package ru.alfabank.hw.hw6.service;

import ru.alfabank.hw.hw6.model.Parcel;

public class ParcelService {
    public void printParcelsReport(Parcel[] parcels) {
        for (Parcel p : parcels) {
            p.printInfo();
            System.out.printf(String.format("Стоимость доставки: %.2f%n", p.calculateDeliveryPrice()));
            System.out.println();
        }
    }
}
