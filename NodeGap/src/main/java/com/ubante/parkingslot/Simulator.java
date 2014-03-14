package com.ubante.parkingslot;

/**
 * Created by Con_0 on 3/12/14.
 */
public class Simulator {

    enum CarNames {
        Subaru, Toyota, BMW, Jeep, Ford, GM, Audi, Nissan, Hyundai, Benz
    }

    /**
     * Main class
     * @param args
     */
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot(10);
        Car aCar = new Car();

        parkingLot.park(aCar);
        parkingLot.print();

        for (int i=10; i<16; i++) {
            parkingLot.park(new Car(Integer.toString(i)));
        }

        System.out.println();
        parkingLot.print();

        System.out.println();
        parkingLot.printShort();

        System.out.println();
    }
}
