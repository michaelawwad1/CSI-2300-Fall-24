package shapes;

import utilities.Resizable;

public class Rectangle extends Shape implements Resizable {
    private double length, width;

    public Rectangle() {
        this.length = 1;
        this.width = 1;
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public void calculateArea() {
        area = length * width;
    }

    @Override
    public void calculatePerimeter() {
        perimeter = 2 * (length + width);
    }

    public void resize(double factor) {
        this.length *= factor;
        this.width *= factor;
        calculateArea();
        calculatePerimeter();
    }
}
