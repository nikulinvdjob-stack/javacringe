package delivery.model;

public class FragileParcel extends Parcel {

    private boolean requiresCarefulHandling;

    public FragileParcel(String recipientName,
                         String recipientAddress,
                         double weight,
                         String trackNumber,
                         boolean requiresCarefulHandling) {

        super(recipientName,
                recipientName,
                weight,
                trackNumber);

        this.requiresCarefulHandling = requiresCarefulHandling;
    }

    public double calculateDeliveryPrice() {
        return super.calculateDeliveryPrice() + 200;
    }

    public void printInfo() {
        super.printInfo();
        System.out.printf("Handle with care: %b\n", this.requiresCarefulHandling);
    }
}
