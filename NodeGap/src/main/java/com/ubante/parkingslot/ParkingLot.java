package com.ubante.parkingslot;

/**
 * Created by Con_0 on 3/12/14.
 */
public class ParkingLot {
    Slot[] slotList;
    int occupiedSlotCount = 0;

    ParkingLot(int numberOfSlots) {
        slotList = new Slot[numberOfSlots];
        for (int i =0; i<numberOfSlots; i++) {
            slotList[i] = new Slot(Integer.toString(i));
            slotList[i].empty();
        }
    }

    int size() {
        return slotList.length;
    }

    void print() {
        for (int i=0; i<size(); i++) {
            Slot s = slotList[i];
            s.print();
        }
    }

    void printShort() {
        for (int i=0; i<size(); i++) {
            Slot s = slotList[i];
            s.printShort();
        }
        System.out.println();
    }

    void printMatrix() {
        int index=0;
        int rowCount = 3;
        int columnCount = size()/rowCount + 1;

        for (int row=0; row<rowCount; row++) {
            for (int column=0; column<columnCount; column++) {
                System.out.printf("%-20s",slotList[index].getDescription());
                index++;

                if (index>=size()) {
                    break;
                }
            }
            System.out.println();
        }
    }

    void park(Car c) {
        for (int i=0; i<size(); i++) {
            if (! slotList[i].isOccupied) {
                slotList[i].fill(c);
                occupiedSlotCount++;
                return;
            }
        }
    }

    void park(int numberOfCars) {
        for (int i=1; i<=numberOfCars; i++) {
            park(new Car());
        }
    }

    void park(Show show) {
        for (int i=1; i<=show.movie.viewers; i++) {
            park (new Car(show));
        }
    }

    void unpark(int numberOfCars) {
        int carsUnparked = 0;
        for (Slot s : slotList) {
            if (carsUnparked == numberOfCars) {
                return;
            }

            if (s.isOccupied) {
                s.empty();
                carsUnparked++;
                occupiedSlotCount--;
            }
        }

        System.out.println("FATAL: We are trying to unpark an empty parking lot.");
    }

    void unpark(Show show) {
        for (Slot s : slotList) {
            if (s.isOccupied) {
                Car car = s.occupier;
                if (car.getShow() == show) {
                    s.empty();
                    occupiedSlotCount--;
                }
            }
        }
    }


//    void unpark(int slotIndex) {
//        slotList[slotIndex].empty();
//        occupiedSlotCount--;
//    }



    int getOccupiedSlotCount() { return occupiedSlotCount; }

    void printStatusMatrix() {
        int index=0;
        double columnCount = 200.0;
        double doubleColumnCount = (double) columnCount;
        int rowCount = (int) Math.ceil((size()/doubleColumnCount));

        for (int row=0; row<rowCount; row++) {
            for (int column=0; column<columnCount; column++) {
                if (slotList[index].isOccupied) {
                    Car car = slotList[index].occupier;
                    System.out.printf("%s ",car.getShowInitial());
                } else {
                    System.out.printf(". ");
                }
                index++;

                if (index>=size()) {
                    break;
                }
            }
            System.out.println();
        }
    }

    void printStatus() {
        System.out.printf("There are %d slots and %d are occupied.\n",size(),
                getOccupiedSlotCount());
        printStatusMatrix();
    }

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10);

        System.out.println("The parking lot has "+pl.size()+" slots");
        pl.print();

        System.out.println();
        Car car = new Car("Scubie");
        pl.park(car);
        pl.print();

        ParkingLot parkingLot = new ParkingLot(400);
        Car aCar = new Car();

        parkingLot.park(aCar);
        parkingLot.print();

        for (int i=10; i<16; i++) {
            parkingLot.park(new Car(Integer.toString(i)));
        }

        for (int i=20; i<36; i++) {
            parkingLot.park(new Car(Integer.toString(i)));
        }

        System.out.println();
        parkingLot.print();

        System.out.println();
        parkingLot.printShort();

//        System.out.println();
//        parkingLot.printMatrix();

//        System.out.println("\nUnparking slot 13:");
//        parkingLot.unpark(13);
//        parkingLot.printMatrix();

        System.out.println("\nThis is the status of the parking lot:");
        parkingLot.printStatus();

        // Park 100 cars
        parkingLot.park(100);
        System.out.println("After parking more cars:");
        parkingLot.printStatus();

        // Unpark 50 cars
        parkingLot.unpark(50);
        System.out.println("After unparking 50 cars:");
        parkingLot.printStatus();

    }
}







