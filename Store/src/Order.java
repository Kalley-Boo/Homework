import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
    String recipient;
    Currency currency;
    LocalDate deliveryOn;
    ArrayList<Product> items;

    public Order(String recipient, Currency currency,
                 LocalDate deliveryOn){
        this.recipient = recipient;
        this.currency = currency;
        this.deliveryOn = deliveryOn;
        items = new ArrayList<>();
    }

    public void displayOrderItems(){
        if(items.size() == 0){
            System.out.println("No items!");
        }
        StringBuilder builder = new StringBuilder("Items: ");
        for(Product item : items){
            builder.append(String.format("%s ", item.getDisplayInfo()));
        }
        System.out.println(builder.toString());
    }

    public void displayGeneralInfo(){
        System.out.printf("Order to: %s | Delivery on: %s | Total: %s",
                            recipient, deliveryOn, calculateTotalPrice());
    }
    public double calculateTotalPrice(){
        double total = 0;

        for(Product product : items){
            total += product.price;
        }

        if(currency == Currency.EUR){
            total = total * 2;
        }
        return total;
    }
}
