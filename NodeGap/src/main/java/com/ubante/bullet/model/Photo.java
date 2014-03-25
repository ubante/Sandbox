package com.ubante.bullet.model;

import java.util.Calendar;

/**
 * Created by Con_0 on 3/24/14.
 */
public class Photo {
    Calendar takenTime;

    Photo() {
        takenTime = Calendar.getInstance();
    }

    void print() {
        System.out.println(takenTime.getTime());
    }

    public static void main(String[] args) {
        Photo p = new Photo();
        p.print();
    }
}
