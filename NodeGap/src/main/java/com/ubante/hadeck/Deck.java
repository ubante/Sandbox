package com.ubante.hadeck;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Con_0 on 3/8/14.
 */
public class Deck {
    int standardDeckSize = 52;
    Card[] cards = new Card[standardDeckSize];

    Deck() {
        for (int i=0; i<52; i++) {
            cards[i] = new Card(Integer.toString(i+1));
        }
    }

    void print() {
        for (Card c : cards) {
            c.print();
        }
    }

    void printMatrix(int width) {
        for (int i=0; i<cards.length; i++) {
            System.out.printf("%3s ",cards[i].face);
            if ((i+1) % width == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    void shuffle() {
        Collections.shuffle(Arrays.asList(cards));
//        Card[] shuffledDeck = new Card[52];
    }

    Card[] getCards() {
        return cards;
    }

    /**
     * For testing the class.
     * @param args
     */
    public static void main(String[] args) {
        Deck d = new Deck();

//        d.print();
        d.printMatrix(20);
        d.shuffle();
        System.out.println("\nAnd after:");
        d.printMatrix(20);
        System.out.println("\nNow getting the list of cards in the deck.");
        Card[] listOfCards = d.getCards();
        for ( Card c : listOfCards) {
            c.print();
        }
    }
}
