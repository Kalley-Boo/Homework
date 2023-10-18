import java.time.LocalDate;

public class Order {
    String recipient;
    double total;
    String currency;
    LocalDate deliveryOn;
    String[] items;

    public Order(String recipient, double total,
                 String currency, LocalDate deliveryOn,
                 String[] items){
        this.recipient = recipient;
        this.total = total;
        this.currency = currency;
        this.deliveryOn = deliveryOn;
        this.items = items;
    }

    public void displayOrderItems(){
        if(items.length == 0){
            System.out.println("No items!");
        }
        StringBuilder builder = new StringBuilder("Items: ");
        for(String item : items){
            builder.append(String.format("%s ", item));
        }
        System.out.println(builder.toString());
    }

    public void displayGeneralInfo(){
        System.out.printf("Order to: %s | Delivery on: %s | Total: %s",
                            recipient, deliveryOn, total);
    }
}
