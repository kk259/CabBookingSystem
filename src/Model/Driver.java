package Model;

import java.awt.*;

public class Driver {
    private int id;
    private char gender;
    private int age;
    private Vehicle vehicle;
    private Point location;
    private int customerId;

    public Driver(int id, char gender, int age, Vehicle vehicle, Point location) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.vehicle = vehicle;
        this.location = location;
    }

    public Driver(int id, char gender, int age, Vehicle vehicle, Point location, int customerId) {
        this.id = id;
        this.gender = gender;
        this.age = age;
        this.vehicle = vehicle;
        this.location = location;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", gender=" + gender +
                ", age=" + age +
                ", vehicle=" + vehicle +
                ", location=" + location +
                ", customerId=" + customerId +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
