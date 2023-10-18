public class Product {
    String name;
    double price;
    Currency currency;

    public Product(String name, double price, Currency currency){
        this.name = name;
        this.price = price;
        this.currency = currency;
    }

    public Product(String name, double price){
        this(name, price, Currency.BGN);
    }

    public String getDisplayInfo(){
        return String.format("%s - %.2f %s", name, price, currency);
    }
}
