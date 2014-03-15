package com.ubante.parkingslot;

/**
 * Created by Con_0 on 3/12/14.
 */
public class ParkingLot {
    Slot[] slotList;

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
                return;
            }
        }
    }

    public static void main(String[] args) {
        ParkingLot pl = new ParkingLot(10);

        System.out.println("The parking lot has "+pl.size()+" slots");
        pl.print();

        System.out.println();
        Car car = new Car("Scubie");
        pl.park(car);
        pl.print();

    }
}
