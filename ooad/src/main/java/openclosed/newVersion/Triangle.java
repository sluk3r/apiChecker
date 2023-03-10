package openclosed.newVersion;

public class Triangle implements Shape {
    double a;
    double b;
    double c;
    
    
    // 定义一个公共方法来计算面积，使用海伦公式
    @Override
    public double area() {
        // 计算半周长
        double s = (a + b + c) / 2;
        // 计算面积并返回结果，使用Math类的sqrt方法来开平方根
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }
    
    // getter and setter omitted
}
