package com.ubante.nodegap;


import java.util.Random;

/**
 * Created by Con_0 on 2/13/14.
 */
public class Distribution {

    static int[] makeDistribution(int min, int max, int count, int total) {
        int[] list = new int[count];
        int listTotal = 0;
        float normalizeRatio;
        float[] flist = new float[count];

        // Handle the cases where total is inappropriate
        if (total < (min*count)) {
            // XXX exception
        }
        if (total > (max*count)) {
            // XXX exception
        }

        // Make a list of random numbers that fit the range
        Random r = new Random();
        for (int i = 0; i < count; i++) {
            int number = min + r.nextInt(max-min+1);
            list[i] = number;
            listTotal = listTotal + number;
        }

        // Normalize them to the total
        normalizeRatio = (float)total / listTotal;
        System.out.printf("total is %d, listtotal is %d\n",total,listTotal);
        System.out.printf("ratio is %4f\n\n",normalizeRatio);
        for (int i = 0; i < count; i++) {
            flist[i] = list[i] * normalizeRatio;
            System.out.printf("%d becomes %4f\n",list[i],flist[i]);
        }

        // Account for rounding errors
        listTotal = 0;
        for (int i = 0; i < count; i++) {
            list[i] = Math.round(flist[i]);
            System.out.printf("%4f becomes %d\n",flist[i],list[i]);
            listTotal = listTotal + list[i];
        }
        System.out.printf("New total is %d\n",listTotal);
        System.out.printf("We want a total of %d so the difference is %d\n",total,(listTotal-total));

        // Return the list
        return list;
    }

    public static void main(String[] args) {
        makeDistribution(3,9,5,400);
    }
}



/*
2 4 6 6 = 18
I want 36
ratio is 2
so
4 8 12 12
 */