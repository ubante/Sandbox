package com.ubante.bullet.model;

/**
 * Created by Con_0 on 3/19/14.
 */
public class Launcher {


    static void printStats(Shooter s) {
        System.out.printf("%s has %d photos\n",s.humanName,s.getGallerySize());
    }

    static void printStats(ShooterList sl) {
        for (Shooter s : sl.getShooters()) {
            printStats(s);
        }
    }

    static void info(String message) {
        System.out.println("\n--------- "+message);
    }


    /**
     * Main main
     * @param args
     */
    public static void main(String[] args) {
        ShooterList sl = new ShooterList("Circus Shooters");

        info("Make Annie");
        Shooter annie = new Shooter("Annie");
        annie.setDevice(new Device());
        annie.shoot();
//        annie.printStatus();

        info("Make Charles and join list");
        Shooter charles = new Shooter("Charles");
        charles.setDevice(new Device("HTC 1000"));
        charles.setLeftSide(annie);
        charles.shoot(2);
        charles.joinShooterList(sl);

        info("List");
        sl.printStatus();

        info("Make Bert and join list");
        Shooter bert = new Shooter("Bert");
        bert.setDevice(new Device("Apple iPad"));
        bert.setLeftSide(annie);
        bert.setRightSide(charles);
        bert.joinShooterList(sl);

        info("List");
        sl.printStatus();

        info("List stats");
        printStats(sl);

        info("Shoot bullet photo and list stats");
        sl.shootBulletPhoto();
        printStats(sl);

        info("Here are the bullet photos");
        sl.printBulletPhotos();

        info("Annie joins list");
        annie.joinShooterList(sl);
        sl.printStatus();
        printStats(sl);

        info("Shoot another bullet photo");
        sl.shootBulletPhoto();
        printStats(sl);

        info("Here are the bullet photos");
        sl.printBulletPhotos();

        info("Doggie, Elephant, Fox, Gorrilla and Hugo join");
        Shooter doggie = new Shooter("Doggie");
        doggie.joinShooterList(sl);
        Shooter elephant = new Shooter("Elephant");
        elephant.joinShooterList(sl);
        Shooter fox = new Shooter("Fox");
        fox.joinShooterList(sl);
        Shooter gorilla = new Shooter("Gorilla");
        gorilla.joinShooterList(sl);
        Shooter hugo = new Shooter("Hugo");
        hugo.joinShooterList(sl);
        sl.printStatus();

        info("Annie leaves");
        annie.leaveShooterList();
        sl.printStatus();

    }
}
