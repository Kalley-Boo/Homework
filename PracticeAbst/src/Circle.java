public class Circle extends Shape{
    double radius;

    public Circle(String colour, double radius){
        super(colour);
        System.out.println("Circle const");
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "Circle colour is: " + colour + "\nArea is: " + area();
    }
}
