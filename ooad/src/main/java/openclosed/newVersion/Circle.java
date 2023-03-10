package openclosed.newVersion;

public class Circle implements Shape {
    double radius;
    
    @Override
    public double area() {
        return radius * radius * Math.PI;
    }
    
    // getter and setter omitted
}
