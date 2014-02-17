package com.ubante.nodegap;

/**
 * This is the start of a game.
 */
public class NodeMap {
    static void display(Node n) {
        n.print();
        n.printChildren();
        n.printDescendents();
    }

    public static void main(String[] args) {
        Node a = new Node("A");
//        Node aa = new Node("aa");
//        Node ab = new Node("ab");
//        Node aba = new Node("aba");
//
//        aa.setParent(a);
//        ab.setParent(a);
//        aba.setParent(ab);
//
//        aa.generateChildren(5);
        a.generateDescendents(500);
        a.printGrandChildren();
        a.printDescendents();

        NodePrinter.HorizontalTree(a);
//        display(a);
    }

}
