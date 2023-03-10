package openclosed.newVersion;


public class AreaCalculator {
    
    public double area(Shape[] shapes) {
        double area = 0;

        for (Shape shape : shapes) {
            area += shape.area();
        }
        
        return area;
    }
}
