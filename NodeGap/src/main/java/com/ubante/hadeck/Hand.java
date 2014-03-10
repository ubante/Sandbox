package com.ubante.hadeck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Con_0 on 3/9/14.
 */
public class Hand {
    List<Card> cards = new ArrayList<Card>();
    int handSizeLimit;

    Hand(int size) {
        this.handSizeLimit = size;
    }

    Hand() {
        this(7);
    }

    void addFirstCard(Card c) {
        cards.add(c);
    }

    void addCard(Card c) throws HandTooLargeException {
        int size = size();
        if (size >= handSizeLimit) {
            throw new HandTooLargeException("Hand is full at size "+size+".");
        } else {
            cards.add(c);
        }
    }

    int size() {
        return cards.size();
    }

    void print() {
        for (Card c : cards) {
            System.out.printf("%3s ",c.face);
        }
        System.out.println();
    }

    void order() {
//        Collections.sort(cards);
    }

    /**
     * For testing this class.
     * @param args
     */
    public static void main(String[] args) {
        Hand h = new Hand();
        try {
            h.addCard(new Card("one"));
            h.addCard(new Card("two"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        h.print();

        for (int i=3; i<10; i++) {
            try {
                h.addCard(new Card(Integer.toString(i)));
                h.print();
            } catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
        h.print();

    }
}
