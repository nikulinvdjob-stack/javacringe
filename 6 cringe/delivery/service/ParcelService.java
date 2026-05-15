package delivery.service;

import delivery.model.Parcel;

public class ParcelService {
    public void printParcelsReport(Parcel[] parcels) {
        for (Parcel p : parcels) {
            p.printInfo();
            System.out.printf(String.format("Стоимость доставки: %.2f", p.calculateDeliveryPrice()));
            System.out.println("\n");
        }
    }
}
