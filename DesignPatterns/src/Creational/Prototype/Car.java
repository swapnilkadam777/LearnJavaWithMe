package Creational.Prototype;

public class Car implements Prototype {
    private String make;
    private String model;
    private int year;

    public Car(String make, String model, int year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    // Getters for the properties
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public Prototype clone() {
        return new Car(make, model, year);
    }

    @Override
    public String toString() {
        return year + " " + make + " " + model;
    }
}