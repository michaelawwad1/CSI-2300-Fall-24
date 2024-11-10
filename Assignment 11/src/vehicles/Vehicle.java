package vehicles;

public abstract class Vehicle {
    protected int speed;
    protected final String type;

    public Vehicle(String type) {
        this.type = type;
        this.speed = 0;
    }

    public Vehicle(String type, int speed) {
        this.type = type;
        this.speed = speed;
    }

    public abstract void move();

    public void stop() {
        speed = 0;
    }

    public void accelerate(int increase) {
        speed += increase;
    }
}
