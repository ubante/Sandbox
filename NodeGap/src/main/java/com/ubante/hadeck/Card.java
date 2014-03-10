package com.ubante.hadeck;

/**
 * Created by Con_0 on 3/8/14.
 */
public class Card implements Comparable<Card> {
    final String face;
    String deckNotes;

    Card(String face) {
        this.face = face;
    }

    public String getDeckNotes() {
        return deckNotes;
    }

    public void setDeckNotes(String deckNotes) {
        this.deckNotes = deckNotes;
    }

    void print() {
        System.out.println("card value is: "+face);
    }

    void printCompactVerbose() {
        System.out.printf("%3s (%3s) ",face,deckNotes);
    }

    @Override
    public int compareTo(Card c) {
        int lastComparision;

        // for strings
//        int lastComparision = face.compareTo(c.face);
//        lastComparision = face.compareTo(c.face);

        // for ints
        int faceInt = Integer.parseInt(face);
        int cInt = Integer.parseInt(c.face);
        if (cInt > faceInt) {
            lastComparision = -1;
        } else if (cInt == faceInt) {
            lastComparision = 0;
        } else {
            lastComparision = 1;
        }

        return lastComparision;
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
