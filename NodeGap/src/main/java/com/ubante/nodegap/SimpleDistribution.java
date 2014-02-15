package com.ubante.nodegap;

import java.util.Random;

/**
 * This is when you want N random positive integers to sum to S.
 */
public class SimpleDistribution {
    static int[] makeDistribution(int count, int total) {
//        int[] list = new int[count];
//        int listTotal = 0;
        float listTotal = 0;
        float normalizeRatio;
        float[] flist0 = new float[count];
        float[] flist = new float[count];
        int[] list = new int[count];
        int largestElementIndex = 0;
        float largestElement = 0;

        // Make a list of random numbers that fit the range
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            float number = r.nextFloat();
            flist0[i] = number;
            listTotal = listTotal + number;
        }

        // Normalize them to the total
        normalizeRatio = total / listTotal;
        System.out.printf("total is %d, listtotal is %4f\n",total,listTotal);
        System.out.printf("ratio is %4f\n\n",normalizeRatio);
        for (int i = 0; i < count; i++) {
            flist[i] = flist0[i] * normalizeRatio;
            System.out.printf("%4f becomes %4f\n",flist0[i],flist[i]);
        }

        // Account for rounding errors
        listTotal = 0;
        System.out.println("");
        for (int i = 0; i < count; i++) {
            list[i] = Math.round(flist[i]);
            System.out.printf("%4f becomes %d\n",flist[i],list[i]);
            listTotal = listTotal + list[i];

            // Find the largest element in case we need to skew the total later
            if (list[i] > largestElement) {
                largestElement = list[i];
                largestElementIndex = i;
            }
        }
        float difference = listTotal-total;
        System.out.printf("New total is %4f\n",listTotal);
        System.out.printf("We want a total of %d so the difference is %4f\n",total,difference);

/* If the total of the numbers generated is > than the desired total, then we will shrink the largest
element.  The same element will be made greater if the total generated is < than the total desired.
*/
        list[largestElementIndex] -= difference;

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
//        int [] d = makeDistribution(3,400);
        int [] d = makeDistribution(10,13);

        printDistribution (d);
    }

}
