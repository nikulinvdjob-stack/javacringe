package delivery.app;

import delivery.model.ExpressParcel;
import delivery.model.FragileParcel;
import delivery.model.Parcel;
import delivery.service.ParcelService;

import java.util.Random;

public class Main {

    static double generateW8 () {
        Random random = new Random();
        double min = 1.0;
        double max = 100.0;
        return min + (random.nextDouble() * (max - min));
    }

    static int generateHours () {
        Random random = new Random();
        int min = 0;
        int max = 24*3;
        return random.nextInt((max - min) + 1) + min;
    }

    static String generateTrackNumber (int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            // Generate a random digit from 0 to 9
            sb.append(random.nextInt(10));
        }

        return sb.toString();
    }

    static void main() {
        Parcel parcel = new Parcel("Получатель обычной посылки",
                "Адрес получателя обычной посылки",
                generateW8(),
                generateTrackNumber(12));

        FragileParcel fragileParcel = new FragileParcel("Получатель хрупкой посылки",
                "Адрес получателя хрупкой посылки",
                generateW8(),
                generateTrackNumber(12),
                true);

        ExpressParcel expressParcel = new ExpressParcel("Получатель экспресс посылки",
                "Адрес получателя экспресс посылки",
                generateW8(),
                generateTrackNumber(12),
                generateHours());

        Parcel[] parcels = {
                parcel,
                fragileParcel,
                expressParcel,
                new Parcel()};

        ParcelService parcelService = new ParcelService();

        parcelService.printParcelsReport(parcels);

    }
}
