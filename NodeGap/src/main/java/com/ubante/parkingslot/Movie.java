package com.ubante.parkingslot;

/**
 * Created by Con_0 on 3/12/14.
 */
public class Movie {
    String name;
    int durationMinutes;
    int viewers;

    Movie (String name, int duration, int viewers) {
        this.name = name;
        this.durationMinutes = duration;
        this.viewers = viewers;
    }

    void print() {
        System.out.printf("Movie is called %s, lasts %d minutes and will get %d viewers\n",
                name,durationMinutes,viewers);
    }

    public static void main(String[] args) {
        Movie m1 = new Movie("Action", 120, 100);
        Movie m2 = new Movie("Cartoon", 60, 200);

        m1.print();
        m2.print();
    }
}
