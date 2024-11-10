package shapes;

public abstract class Shape {
    protected double area;
    protected double perimeter;

    public Shape() {
        this.area = 0;
        this.perimeter = 0;
    }

    public Shape(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public abstract void calculateArea();

    public abstract void calculatePerimeter();

    public double getArea() {
        return area;
    }
}
