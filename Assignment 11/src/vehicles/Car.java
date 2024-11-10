package vehicles;

import utilities.Describable;

public class Car extends Vehicle implements Describable {
    private int fuelLevel;

    public Car() {
        super("Car", 0);
        this.fuelLevel = 100;
    }

    public Car(int speed, int fuelLevel) {
        super("Car", speed);
        this.fuelLevel = fuelLevel;
    }

    @Override
    public void move() {
        System.out.println("Car is moving at speed " + speed);
    }

    @Override
    public String getDescription() {
        return "Car with fuel level " + fuelLevel;
    }

    public void refuel(int amount) {
        fuelLevel += amount;
    }
}
