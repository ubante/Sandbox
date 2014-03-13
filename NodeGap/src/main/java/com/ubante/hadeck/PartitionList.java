package com.ubante.hadeck;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Con_0 on 3/12/14.
 */
public class PartitionList {
    List<Partition> partitionList = new ArrayList<Partition>();

    PartitionList() {}

    void addPartition(List<Partition> pList) {
        partitionList.addAll(pList);
    }

    void addPartition(Partition pToBeAdded) {
        partitionList.add(pToBeAdded);
    }

    void printShort() {
        int counter = 0;

        for (Partition p : partitionList) {
            counter++;
            System.out.printf("%d--> ",counter);
            p.print();
        }
    }

    boolean hasPartition(Partition pToBeFound) {
        for (Partition p : partitionList) {
            if (p.name == pToBeFound.name) {
                return true;
            }
        }
        return false;
    }

    void concatenatePartition(Partition pToBeConcatenated) {
        for (Partition p : partitionList) {
            if (p.name == pToBeConcatenated.name) {
                for (Card cardToBeConcatenated : pToBeConcatenated.cardList) {
                    p.add(cardToBeConcatenated);
                }
                return;
            }
        }
    }

    PartitionList merge() {
        PartitionList mergedList = new PartitionList();

        for (Partition p : partitionList) {
            // For each partition, find its name
            String name = p.name;

            // See if that partition already exists in the new merged list
            if (mergedList.hasPartition(p)) {
                // If it does, add the cards in this partition to that partition
                mergedList.concatenatePartition(p);
            } else {
                // If it doesn't, add this partition to the merged list
                mergedList.addPartition(p);
            }
        }

        return mergedList;
    }

    void orderPartitions() {
        for (Partition p : partitionList) {
            p.order();
        }

        return;
    }


}
