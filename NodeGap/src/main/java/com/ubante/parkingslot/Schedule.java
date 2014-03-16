package com.ubante.parkingslot;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Con_0 on 3/15/14.
 */
public class Schedule {
    List<Show> schedule = new ArrayList<Show>();

    Schedule() {}

    void addShow (Show s) { schedule.add(s); }

    void makeDefault() {
        Movie m1 = new Movie("Action", 120, 100);
        Movie m2 = new Movie("Cartoon", 60, 200);
        Movie m3 = new Movie("Drama",180,50);

        addShow(new Show(m1, 13));
        addShow(new Show(m2, 14));
        addShow(new Show(m3, 15));
        addShow(new Show(m1, 16));
        addShow(new Show(m2, 17));
        addShow(new Show(m3, 18));
    }

    void print() {
        for (Show s : schedule) {
            s.print();
        }
    }

    void print2() {
        for (Show s : schedule) {
            System.out.printf("%s: %s\n",s.startTime,s.movie.name);
        }
    }

    public static void main(String[] args) {
        Movie m1 = new Movie("Action", 120, 100);
        Movie m2 = new Movie("Cartoon", 60, 200);
        Movie m3 = new Movie("Drama",180,50);
        Schedule schedule = new Schedule();
        schedule.addShow(new Show(m1,13));
        schedule.addShow(new Show(m2,14));
        schedule.addShow(new Show(m3,15));
        schedule.addShow(new Show(m1,16));
        schedule.addShow(new Show(m2,17));
        schedule.addShow(new Show(m3,18));

        schedule.print();
    }

}
