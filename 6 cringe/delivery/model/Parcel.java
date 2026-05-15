package delivery.model;


public class Parcel {
    private String recipientName;
    private String recipientAddress;
    protected double weight;
    private String trackNumber;

    public Parcel (String recipientName,
            String recipientAddress,
            double weight,
            String trackNumber) {
        this.recipientName = recipientName;
        this.recipientAddress = recipientAddress;
        this.weight = weight;
        this.trackNumber = trackNumber;
    };

    public Parcel() {};

    public String getRecipientName() {
        return recipientName;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public double getWeight() {
        return weight;
    }

    public void setRecipientName(String recipientName) {
        this.recipientName = recipientName;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double calculateDeliveryPrice() {
        return 100 + this.weight * 30;
    }

    public void printInfo() {
        System.out.printf(String.format(
                "Имя получателя: %s%n" +
                "Адрес получателя: %s%n" +
                "Вес поссылки: %.2f%n" +
                "Трек Номер: %s%n",
                this.recipientName,
                this.recipientAddress,
                this.weight,
                this.trackNumber
        ));
    }
}