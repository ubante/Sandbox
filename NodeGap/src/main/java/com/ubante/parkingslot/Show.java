package com.ubante.parkingslot;

/**
 * Created by Con_0 on 3/15/14.
 */
public class Show {
    int startTime;
    Movie movie;

    Show (Movie m, int startTime) {
        this.movie = m;
        this.startTime = startTime;
    }

    void print() {
//        System.out.printf("%s will run from %d until %d\n",
//                movie.name,startTime,startTime+movie.durationMinutes/60);
        System.out.printf("%d - %d: %s\n",startTime,
                startTime+movie.durationMinutes/60,movie.name);
    }

    public static void main(String[] args) {
        Movie m1 = new Movie("Action", 120, 100);
        Movie m2 = new Movie("Cartoon", 60, 200);
        Show afternoon1 = new Show(m1, 13);
        Show afternoon2 = new Show(m2, 14);
        Show afternoon3 = new Show(m1, 15);
        Show evening1 = new Show(m2, 17);
        Show evening2 = new Show(m1, 18);
        Show evening3 = new Show(m2, 19);

        afternoon1.print();

    }
}
