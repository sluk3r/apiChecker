package openclosed;

public class AreaCalculator {
    
    public double area(Rectangle[] rectangles) {
        double area = 0;

        for (Rectangle rectangle : rectangles) {
            area += rectangle.width * rectangle.height;
        }
        
        return area;
    }
}
