package com.ubante.hadeck;

/**
 * Created by Con_0 on 3/8/14.
 */
public class Card {
    String face;

    Card(String face) {
        this.face = face;
    }

    void print() {
        System.out.println("card value is: "+face);
    }

    /**
     * For testing the class.
     * @param args
     */
    public static void main(String[] args) {
        Card c = new Card("30");

        c.print();
    }
}
