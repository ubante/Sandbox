package com.ubante.parkingslot;

import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * Created by Con_0 on 3/12/14.
 */
public class Slot {
    boolean isOccupied;
    Car occupier;
    String name;

    Slot(String name) {
        this.name = name;
        empty();
    }

    Slot() {
        this("defaultslotname");
    }

    void empty() {
        isOccupied = false;
        occupier = null;
    }

    void fill(Car car) {
        isOccupied = true;
        occupier = car;
    }

    void print() {
        String message;

        if (isOccupied) {
            message = String.format("Slot is named %s and is occupied by %s",
                    name,occupier.name);
        } else {
            message = String.format("Slot is named %s and is not occupied",name);
        }

        System.out.println(message);
    }

    String getDescription() {
        if (isOccupied) {
            return String.format("%s(%s)  ", name, occupier.name);
        } else {
            return String.format("%s(empty)  ", name);
        }
    }

    void printShort() {
        System.out.printf(getDescription());
    }

    public static void main(String[] args) {
        Car bCar = new Car("Subaru");
        Slot bSlot = new Slot();
        bSlot.fill(bCar);
        bSlot.print();

        Slot cSlot = new Slot();
        cSlot.empty();
        cSlot.print();

        Slot dSlot = new Slot("B30");
        dSlot.print();
    }
}
