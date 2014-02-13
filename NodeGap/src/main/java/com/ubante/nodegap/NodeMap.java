package com.ubante.nodegap;

/**
 * This is the start of a game.
 */
public class NodeMap {
    static void display(Node a) {
        a.print();
        a.printChildren();
        a.printAncestors();
        a.generateChildren(3);
        a.printAncestors();
    }

    public static void main(String[] args) {
        Node a = new Node("a");
        Node aa = new Node("aa");
        Node ab = new Node("ab");
        Node aba = new Node("aba");

        aa.setParent(a);
        ab.setParent(a);
        aba.setParent(ab);

        aa.generateChildren(5);

        display(a);
    }

}
