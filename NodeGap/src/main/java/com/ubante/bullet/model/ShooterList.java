package com.ubante.bullet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Con_0 on 3/19/14.
 */
public class ShooterList {
    List<Shooter> shooters = new ArrayList<Shooter>();
    String name;
    List<Photo> bulletPhotos;

    ShooterList(String name) { this.name = name; }

    ShooterList() { this("defaultshooterlistname"); }

    void join(Shooter s) {
        shooters.add(s);
    }

    void leave(Shooter s) {
        shooters.remove(s);
    }

    List<Shooter> getShooters() { return shooters; }

    void shootBulletPhoto() {
        // Need the countdown here.
        // Do ping to make sure shooters are still available

        List<Photo> photoList = new ArrayList<Photo>();
        for (Shooter s : getShooters()) {
            s.shoot();
            Photo p = s.getLastPhoto();
            photoList.add(p);
        }
        bulletPhotos = photoList;
    }

    void printBulletPhotos() {
        for (Photo p : bulletPhotos) {
            p.print();
        }
    }

    void printStatus() {
        System.out.println("ShooterList: "+name);
        System.out.printf("Size: %d\n",shooters.size());
        System.out.printf("Members: ");
        for (Shooter s : shooters) {
            System.out.printf("%s ",s.humanName);
        }
        System.out.println();

    }

    /**
     * Test main.
     * @param args
     */
    public static void main(String[] args) {
        ShooterList pl = new ShooterList();

        Shooter annie = new Shooter();

    }
}
