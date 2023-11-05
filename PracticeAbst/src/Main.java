public class Main {
    public static void main(String[] args) {
        Shape s = new Circle("Red", 3.2);
        Shape ss = new Rectangle("Pink" , 4, 3);

        System.out.println(s.toString());
        System.out.println(ss.toString());
    }
}