public class Rectangle extends Shape{
    double length;
    double width;

    public Rectangle(String colour, double length, double width){
        super(colour);
        System.out.println("Rect const");
        this.length = length;
        this.width = width;
    }
    @Override
    double area() {
        return length * width;
    }

    @Override
    public String toString() {
        return "Rectangle color is: " + super.getColour()
                + "\nArea is: " + area();
    }
}
