package ru.alfabank.hw.hw6.model;

public class ExpressParcel extends Parcel {

    private int deliveryHours;

    public ExpressParcel(String recipientName,
                         String recipientAddress,
                         double weight,
                         String trackNumber,
                         int deliveryHours) {

        super(recipientName,
                recipientName,
                weight,
                trackNumber);

        this.deliveryHours = deliveryHours;
    }

    public double calculateDeliveryPrice() {
        return super.calculateDeliveryPrice() + (deliveryHours < 24 ? 500 : 0);
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf(String.format("Delivery deadline: %d%n", this.deliveryHours));
    }
}