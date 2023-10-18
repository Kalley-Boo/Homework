import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("John",
                Currency.BGN,
                LocalDate.now());
        order1.items.add(new Product("Keyboard", 50));
        order1.items.add(new Product("Monitor", 100));

        Order order2 = new Order("Frank", Currency.EUR,
                LocalDate.now());
        order2.items.add(new Product("T-shirt", 10));
        order2.items.add(new Product("Jeans", 20));

        Order[] orders = new Order[]{order1, order2};

        for(Order order : orders){
            order.displayGeneralInfo();
            System.out.println();
            order.displayOrderItems();
            System.out.println("------------------");
        }
    }
}