package com.ubante.pi;

/**
 * Created by Con_0 on 3/16/14.
 */
public class DartSimulation {


    public static void main(String[] args) {
        Dartboard db = new Dartboard(10);

        for (int i=0; i<10000000; i++) {
            Dart d = new Dart(db);;
            d.toss();

//            d.print();
            db.printStatus();
        }
    }
}

/**
 78516 darts of 100000 are inside for a ratio of 3.140640 (99.970% of pi)
 78474 darts of 100000 are inside for a ratio of 3.138960 (99.916% of pi)
 78634 darts of 100000 are inside for a ratio of 3.145360 (100.120% of pi)
 78465 darts of 100000 are inside for a ratio of 3.138600 (99.905% of pi)
 78507 darts of 100000 are inside for a ratio of 3.140280 (99.958% of pi)
 785521 darts of 1000000 are inside for a ratio of 3.142084 (100.016% of pi)
 784420 darts of 1000000 are inside for a ratio of 3.137680 (99.875% of pi)

 */