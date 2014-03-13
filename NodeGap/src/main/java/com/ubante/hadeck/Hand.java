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
    List<Partition> partitionList = new ArrayList<Partition>();

    /**
     * Constructors.
     * @param size
     */
    Hand(int size) {
        this.handSizeLimit = size;
    }

    Hand() {
        this(7);
    }

    void addFirstCard(Card c) {
        cards.add(c);
    }

    /**
     * Add a card to a hand.  Throw an exception if the hand is too large.
     * @param c
     * @throws HandTooLargeException
     */
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
            c.printCompactVerbose();
        }
        System.out.println();
    }

    void order() {
        Collections.sort(cards);
    }

    void fillPartitions(PartitionList masterList) {

        for (Card c : cards) {
            String note = c.deckNotes;
            Partition partition = null;

            for (Partition p : partitionList) {
                if (p.name == note) {
                    partition = p;
                    break;
                }
            }

            // Create a new partition if a matching one does not yet exist.
            if (partition == null) {
                partition = new Partition(note);
                partitionList.add(partition);
            }

            // Add this card.
            partition.add(c);
        }

        // Add the partitions to the master list of partitions for the merge
        // step.
        masterList.addPartition(partitionList);
    }

    void printParitions() {
        System.out.println("These are the partitions for the hand.  ");
        for (Partition p : partitionList) {
            p.print();
        }
    }

    /**
     * For testing this class.
     * @param args
     */
    public static void main(String[] args) {
        Hand h = new Hand();
        try {
            Card c5 = new Card("5");
            c5.setDeckNotes("aaa");
            h.addCard(c5);
            Card c15 = new Card("15");
            c15.setDeckNotes("bbb");
            h.addCard(c15);
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i=13; i>5; i--) {
            try {
                Card aCard = new Card(Integer.toString(i));
                aCard.setDeckNotes("ccc");
                h.addCard(aCard);
//                h.addCard(new Card(Integer.toString(i)));
//                h.print();
            } catch (Exception e) {
//                e.printStackTrace();
                break;
            }
        }
        h.print();
        h.order();
        h.print();
        System.out.println();

//        h.fillPartitions();
        System.out.println("\n\nThe final partition list:");
        h.printParitions();
    }
}
