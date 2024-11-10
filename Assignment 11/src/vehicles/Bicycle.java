package vehicles;

import utilities.Resizable;

public class Bicycle extends Vehicle implements Resizable {
    private int gearCount;

    public Bicycle() {
        super("Bicycle", 10);
        this.gearCount = 1;
    }

    public Bicycle(int speed, int gearCount) {
        super("Bicycle", speed);
        this.gearCount = gearCount;
    }

    @Override
    public void move() {
        System.out.println("Bicycle is moving at speed " + speed);
    }

    @Override
    public void resize(double factor) {
        this.gearCount *= factor;
    }
}
