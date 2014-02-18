package com.ubante.nodegap;

/**
 * This is for testing other classes.
 */
public class Utility {
    public static void main(String[] args) {
        Node x = new Node("X");
        x.generateChildren(3);
        Node w = new Node("W");
        w.generateChildren(5);
        w.setParent(x);
        Node y = new Node("Y");
        y.generateChildren(4);
        Node z = new Node("Z");
        x.setParent(z);
        y.setParent(z);
        Node T = new Node("T");
        T.setParent(z);

        z.printChildren();
        System.out.println();

        z.printGrandChildren();
        System.out.println();

        NodePrinter.HorizontalTreeNoLeaves(z);
        NodePrinter.VerticalTree(z);

//        float fff = 3-2;
//        System.out.println(fff);
    }

}
