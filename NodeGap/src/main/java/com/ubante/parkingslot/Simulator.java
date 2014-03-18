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
        ParkingLot pl = new ParkingLot(380);
        Schedule schedule = new Schedule();
        schedule.makeDefault();

        schedule.printCapacity();

        for (int hour = schedule.getStartTime(); hour<24; hour++ ) {
            System.out.printf("                         The time is %d:00\n",
                    hour);

            // Find the movies that start during this hour.
//            for (Movie m : schedule.getMoviesThatStartAt(hour)) {
//                System.out.println("+++++ Starting "+m.name);
//                pl.park(m.viewers);
//                pl.printStatus();
//            }

            for (Show s : schedule.getShowsThatEndAt(hour)) {
                System.out.println("----- Ending "+s.movie.name);
                pl.unpark(s);
                pl.printStatus();
            }

            for (Show s : schedule.getShowsThatStartAt(hour)) {
                System.out.println("+++++ Starting "+s.movie.name);
                pl.park(s);
                pl.printStatus();
            }


        }
    }
}
