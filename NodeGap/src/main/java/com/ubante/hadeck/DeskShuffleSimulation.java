package com.ubante.hadeck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Con_0 on 3/8/14.
 */
public class DeskShuffleSimulation {
    static int numberOfDecks = 3;
    static SuperDeck s = new SuperDeck(numberOfDecks);
    static List<Hand> hands = new ArrayList<Hand>();

    static void printHands() {
        System.out.println("These are the hands:");
        for (Hand h : hands) {
            h.print();
        }
    }

    /**
     * Main main.
     * @param args
     */
    public static void main(String[] args) {

        s.printMatrix();
        System.out.println("Now we shuffle:");
        s.shuffle();
        s.printMatrix();

        // Divide into hands
        int sizeOfaHand = 9;
        Hand currentHand = new Hand();
        hands.add(currentHand);
        for (Card card : s.getCards()) {
            try {
                currentHand.addCard(card);
            } catch (HandTooLargeException htle) {
                Hand newHand = new Hand();
                newHand.addFirstCard(card);
                currentHand = newHand;
                hands.add(currentHand);
            }
        }
//        printHands();

        // Order the hands
        for (Hand h : hands) {
            h.order();
        }
        printHands();

        // Fill the partitions
        // Later, put this in a thread for each hand.
        for (Hand h : hands) {
            h.fillPartitions();
            h.printParitions();
        }

        // Merge the partitions


    }
}
