package shapes;

import utilities.Resizable;

public class Circle extends Shape implements Resizable {
    private double radius;

    public Circle() {
        this.radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void calculateArea() {
        area = Math.PI * radius * radius;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }

    public void resize(double factor) {
        this.radius *= factor;
        calculateArea();
        calculatePerimeter();
    }
}
