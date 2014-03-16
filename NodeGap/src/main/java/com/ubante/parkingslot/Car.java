package com.ubante.parkingslot;

/**
 * Created by Con_0 on 3/12/14.
 */
public class Car {
    String name = "defaultcarname";
    Show show = null;

    Car(String name, Show show) {
        this.name = name;
        this.show = show;
    }

    Car (Show show) {
        this.show = show;
    }

    Car(String name) {
        this.name = name;
    }

    Car() {
        this("defaultcarname");
    }

    void print() {
        System.out.println("This car is named: "+name);
    }

    String getShowInitial() {
        if (show == null) {
            return "N";
        } else {
            return show.movie.name.substring(0,1);
        }
    }

    Show getShow() { return show; }

    public static void main(String[] args) {
        Car aCar = new Car();
        aCar.print();
        Car bCar = new Car("Subaru");
        bCar.print();
    }
}
