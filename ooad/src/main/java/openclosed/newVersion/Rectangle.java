package openclosed.newVersion;

public class Rectangle implements Shape {
    double width;
    double height;
    
    @Override
    public double area() {
        return width * height;
    }
    
    // getter and setter omitted
}
