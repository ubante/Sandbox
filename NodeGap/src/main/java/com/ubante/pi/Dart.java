package com.ubante.pi;

import java.util.Random;

/**
 * Created by Con_0 on 3/16/14.
 */
public class Dart {
    double x,y;
    Random r = new Random();
    Dartboard db;
    double distanceFromCenter;

    Dart(Dartboard db) {
        this.db = db;
        x = y = -1;
        db.addDart(this);
    }

    double getDistance(double max) {
        return r.nextDouble() * max;
    }

    void toss() {
        x = getDistance(db.width);
        y = getDistance(db.height);

        // Compute distance
        distanceFromCenter = Math.sqrt(
                (db.radius-x)*(db.radius-x) +
                (db.radius-y)*(db.radius-y)
        );

        db.record(this);
    }

    void print() {
        System.out.printf("Location: %f,%f (distance=%f)\n",x,y,distanceFromCenter);
    }

    public static void main(String[] args) {
        Dartboard db = new Dartboard(30);
        Dart d = new Dart(db);
        d.toss();
        d.print();
    }

}


