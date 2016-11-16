package Builder;

/**
 * Created by andri on 11/16/2016.
 */
enum Transmission {
    Manual, Auto;
}

class Car {
    private String make;
    private Transmission transmission;
    private int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

public abstract class Builder {
    private Car car;

    public Car getCar() {
        return car;
    }

    public void createCar() {
        car = new Car();
    }

    public abstract void buildMake();
    public abstract void buildTransmission();
    public abstract void buildMaxSpeed();
}

class FerrariBuilder extends Builder{
    @Override
    public void buildMake() {
        getCar().setMake("Ferrari");
    }

    @Override
    public void buildTransmission() {
        getCar().setTransmission(Transmission.Auto);
    }

    @Override
    public void buildMaxSpeed() {
        getCar().setMaxSpeed(350);
    }
}

class MercedesBuilder extends Builder {
    @Override
    public void buildMake() {
        getCar().setMake("Mercedes");
    }

    @Override
    public void buildTransmission() {
        getCar().setTransmission(Transmission.Manual);
    }

    @Override
    public void buildMaxSpeed() {
        getCar().setMaxSpeed(300);
    }
}

class Director {
    private Builder builder;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public Car buildCar() {
        builder.createCar();
        builder.buildMake();
        builder.buildTransmission();
        builder.buildMaxSpeed();
        return builder.getCar();
    }
}

class Main {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new FerrariBuilder());
        Car ferrariCar = director.buildCar();
        System.out.println(ferrariCar.toString());
    }
}
