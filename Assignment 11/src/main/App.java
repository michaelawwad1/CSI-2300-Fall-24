package main;

import shapes.Circle;
import vehicles.Car;

public class App {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        circle.calculateArea();
        circle.calculatePerimeter();
        System.out.println("Circle area: " + circle.getArea());

        Car car = new Car(60, 50);
        car.move();
        System.out.println(car.getDescription());
    }
}
