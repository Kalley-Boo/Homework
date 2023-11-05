public abstract class Shape {
    String colour;

    abstract double area();
    public abstract String toString();

    public Shape (String colour){
        System.out.println("Shape constr.");
        this.colour = colour;
    }

    public String getColour(){
        return colour;
    }
}
