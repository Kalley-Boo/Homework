import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Order order1 = new Order("John", 400, "BGN",
                LocalDate.now(), new String[]{"PC", "Keyboard", "Mouse"});

        Order order2 = new Order("Frank", 120, "EUR",
                LocalDate.now(), new String[]{"Jeans", "T-shirt"});

        Order[] orders = new Order[]{order1, order2};

        for(Order order : orders){
            order.displayGeneralInfo();
            System.out.println();
            order.displayOrderItems();
            System.out.println("------------------");
        }
    }
}