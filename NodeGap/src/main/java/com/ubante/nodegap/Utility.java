package com.ubante.nodegap;

/**
 * This is for testing other classes.
 */
public class Utility {
    public static void main(String[] args) {
        Node a = new Node("Ancestor");
        a.generateChild("1");

        a.printChildren();

        int number = 1;

        System.out.println("number is " + number);
        number = number + 1;
        System.out.println("number is " + number);
        number++;
        System.out.println("number is " + number);
    }
}
