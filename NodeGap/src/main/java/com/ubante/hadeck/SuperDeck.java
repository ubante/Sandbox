package com.ubante.hadeck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Con_0 on 3/8/14.
 */
public class SuperDeck {
    List<Card> listOfCards = new ArrayList<Card>();

    SuperDeck(int deckCount) {
        for (int ctr = 0; ctr<deckCount; ctr++) {
            Deck newDeck = new Deck();
            String deckNote = Integer.toString(ctr+100);
            newDeck.setDeckNotes(deckNote);
            listOfCards.addAll(Arrays.asList(newDeck.getCards()));
        }
    }

    void printMatrix(int width) {
        int counter = 0;

        for (Card c : listOfCards) {
            c.printCompactVerbose();
            counter++;
            if ( counter % width == 0) {
                System.out.println();
                counter = 0;
            }
        }
        System.out.println();
    }

    void printMatrix() {
        printMatrix(52);
    }

    void shuffle() {
        Collections.shuffle(listOfCards);
    }

    List<Card> getCards() {
        return listOfCards;
    }



    /**
     * For testing the class.
     * @param args
     */
    public static void main(String[] args) {
        SuperDeck s = new SuperDeck(3);

        s.printMatrix(40);
    }
}
