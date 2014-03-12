package com.ubante.hadeck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Con_0 on 3/10/14.
 */
public class Partition {
    static List<Partition> totalPartitionList = new ArrayList<Partition>();
    String name;
    List<Card> cardList = new ArrayList<Card>();

    Partition(String name) {
        this.name = name;
    }

    void add(Card c) {
        cardList.add(c);
    }

    void print() {
        System.out.printf("Partition " + name + ": ");
        for (Card c : cardList) {
            c.printCompactVerbose();
        }
        System.out.println();
    }
      
    static void addPartition(Partition p) {
        totalPartitionList.add(p);
    }
}
