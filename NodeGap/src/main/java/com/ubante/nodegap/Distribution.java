package com.ubante.nodegap;

import java.util.Random;

/**
 * This is when you want N random integers to sum to S and all integers can be no less than M.
 *
 */
public class Distribution {

    static int[] makeDistribution(int min, int count, int total) {
        int[] list = new int[count];
        int listTotal = 0;
        float normalizeRatio;
        float[] flist = new float[count];

        // Handle the cases where total is inappropriate
        if (total < (min*count)) {
            // XXX exception
        }

        // Make a list of random numbers that fit the range
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            int number = min + r.nextInt(total);
            list[i] = number;
            listTotal = listTotal + number;
        }

        // Normalize them to the total
        normalizeRatio = (float)total / listTotal;
//        System.out.printf("total is %d, listtotal is %d\n",total,listTotal);
//        System.out.printf("ratio is %4f\n\n",normalizeRatio);
        for (int i = 0; i < count; i++) {
            flist[i] = list[i] * normalizeRatio;
//            System.out.printf("%d becomes %4f\n",list[i],flist[i]);
        }

        // Account for rounding errors
        listTotal = 0;
        System.out.println("");
        for (int i = 0; i < count; i++) {
            list[i] = Math.round(flist[i]);
//            System.out.printf("%4f becomes %d\n",flist[i],list[i]);
            listTotal = listTotal + list[i];
        }
        int difference = listTotal-total;
//        System.out.printf("New total is %d\n",listTotal);
//        System.out.printf("We want a total of %d so the difference is %d\n",total,difference);
        list[0] -= difference;

        // Return the list
        return list;
    }

    static void printDistribution(int [] array) {
        System.out.println("\nThis is the distribution:");
        for (int i : array) {
            System.out.printf("%d ",i);
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
//        int [] d = makeDistribution(3,5,400);
        int [] d = makeDistribution(3,10,400);

        printDistribution (d);
    }

}
