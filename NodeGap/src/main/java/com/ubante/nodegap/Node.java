package com.ubante.nodegap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ubante on 2/12/14.
 */
public class Node {
    static int MAXCHILDREN = 10;
    static int MINCHILDREN = 3;
    String name;
    Node parent;
    List<Node> children = new ArrayList<Node>();

    Node(String name) {
        this.name = name;
    }

    void setParent(Node parent) {
        this.parent = parent;
        parent.addChild(this);
    }

    void addChild(Node child) {
        children.add(child);
    }

    void print() {
        System.out.printf("This node is for %s\n", name);
    }

    void printChildren() {
        System.out.printf("%s has these children: ",name);
        for ( Node c : children ) {
            System.out.printf("%s ",c.name);
        }
        System.out.println();
    }

    List<Node> getAncestors() {
        List<Node> ancestors = new ArrayList<Node>();
        for (Node c : children) {
            ancestors.add(c);
            // check for grandchildren aka walk the tree
            List<Node> grandchildren = c.getAncestors();
            if (! grandchildren.isEmpty()) {
                // add the grandchildren to ancestors
                ancestors.addAll(grandchildren);
            }
        }
        return ancestors;
    }

    void printAncestors() {
        System.out.printf("%s has these ancestors: ",name);
        List<Node> ancestors = getAncestors();
        for (Node a : ancestors) {
            System.out.printf("%s ",a.name);
        }
        System.out.println();
    }

    void generateChildren(int count) {
        for (int i=1; i<=count; i++) {
            String childName = name + Integer.toString(i);
            Node c = new Node(childName);
            c.setParent(this);
        }
    }

    void generateAncestors(int count) {
        if (count < MINCHILDREN) {
            generateChildren(count);
        } else if (count > MAXCHILDREN) {
            // we're going to need grandchildren so first generate children
            Random r = new Random();
            int childrenCount = MINCHILDREN + r.nextInt(MAXCHILDREN-MINCHILDREN+1);
            generateChildren(childrenCount);

            // a better way is to use a latent dirichlet allocation, but....

        } else {
            // we should really consider the possibility of grandchildren even in this case, but....
            generateChildren(count);
        }

    }

}
