package com.ubante.parkingslot;

/**
 * Created by Con_0 on 3/12/14.
 */
public class Car {
    String name;

    Car(String name) {
        this.name = name;
    }

    Car() {
        this("defaultcarname");
    }

    void print() {
        System.out.println("This car is named: "+name);
    }

    public static void main(String[] args) {
        Car aCar = new Car();
        aCar.print();
        Car bCar = new Car("Subaru");
        bCar.print();
    }
}
