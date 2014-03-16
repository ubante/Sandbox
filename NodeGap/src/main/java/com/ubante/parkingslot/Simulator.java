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
        ParkingLot parkingLot = new ParkingLot(40);
        Schedule schedule = new Schedule();
        schedule.makeDefault();

        schedule.print();
    }
}
