package com.ubante.bullet.model;

/**
 * Created by Con_0 on 3/19/14.
 */
public class Shooter {
    String humanName;
    Device device;
    Shooter rightSide = null;
    Shooter leftSide = null;

    Shooter() {}

    Shooter(String name) {
        this.humanName = name;
    }

    void setDevice(Device d) { this.device = d; }

    void shoot() {
        device.takePhoto();
    }

    void shoot(int shots) {
        for (int i=1; i<=shots; i++) {
            device.takePhoto();
        }
    }

    void setRightSide(Shooter s) {
        rightSide = s;

        // Don't try this because it causes an infinite loop and overflow.
        // Instead, handle it in the ShooterRing.g
//        s.setLeftSide(this);
    }

    void setLeftSide(Shooter s) {
        leftSide = s;
    }

    void print() {
        System.out.println("------------");
        System.out.println(humanName);
        device.print();
        device.printGallery();
        System.out.println("");
        System.out.printf("On %s leftside is ",humanName);
        if ( leftSide == null ) {
            System.out.printf("unknown");
        } else {
            System.out.printf(leftSide.humanName);
        }
        System.out.printf(" and on rightside is ");
        if ( rightSide == null ) {
            System.out.println("unknown");
        } else {
            System.out.println(rightSide.humanName);
        }
    }

    public static void main(String[] args) {
        Shooter annie = new Shooter("Annie");
        annie.setDevice(new Device());
        annie.shoot();
        annie.print();

        Shooter charles = new Shooter("Charles");
        charles.setDevice(new Device("HTC 1000"));
        charles.setLeftSide(annie);
        charles.shoot(2);
        charles.print();
        annie.print();

        Shooter bert = new Shooter("Bert");
        bert.setDevice(new Device("Apple iPad"));
        bert.setLeftSide(annie);
        bert.setRightSide(charles);
        bert.print();

    }


}
