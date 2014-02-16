package com.ubante.nodegap;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ubante on 2/12/14.
 */
public class Node {
    static int MAXCHILDREN = 9;
    static int MINCHILDREN = 3;
    static int depth = 0;
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

    int getChildrenCount() {
        return children.size();
    }

    void print() {
        System.out.printf("This node's name is %s.\n", name);
    }

    void printChildren() {
        System.out.printf("%s has these %d children: ",name,children.size());
        for (Node c : children) {
            System.out.printf("%s ",c.name);
        }
        System.out.println();
    }

    /*
    This prints the children and their children.
     */
    void printGrandChildren() {
        printChildren();
        for (Node c : children) {
            c.printChildren();
        }
    }

    List<Node> getDescendents() {
        List<Node> descendents = new ArrayList<Node>();
        for (Node c : children) {
            descendents.add(c);
            // check for grandchildren aka walk the tree
            List<Node> grandchildren = c.getDescendents();
            if (! grandchildren.isEmpty()) {
                // add the grandchildren to descendents
                descendents.addAll(grandchildren);
            }
        }
        return descendents;
    }

    void printDescendents() {
        List<Node> descendents = getDescendents();
        System.out.printf("%s has these %d descendents: ",name,descendents.size());
        for (Node a : descendents) {
            System.out.printf("%s ",a.name);
        }
        System.out.println();
    }

    // XXX should these generate methods return what is generated (with the possible exception of
    // generateAncestors)?
    // The first child's suffix is "1" and not "0".
    void generateChild() {
        int currentChildrenCount = getChildrenCount();
        String suffixForNextChild = Integer.toString(currentChildrenCount+1);
        generateChild(suffixForNextChild);
    }

    void generateChild(String suffix) {
        Node child = new Node(name+suffix);
        child.setParent(this);
    }

    void generateChildren(int count) {
        for (int i=1; i<=count; i++) {
            generateChild(Integer.toString(i));
//            String childName = name + Integer.toString(i);
//            Node c = new Node(childName);
//            c.setParent(this);
        }
    }

    void generateAncestors2(int count) {
        if (count < MINCHILDREN) {
            generateChildren(count);
        } else if (count > MAXCHILDREN) {
            // we're going to need grandchildren so first generate children
            Random r = new Random();
            int childrenCount = MINCHILDREN + r.nextInt(MAXCHILDREN-MINCHILDREN+1);
            depth++;
            // a better way is to use a latent dirichlet allocation, but....
            int [] childrenSizes = Distribution.makeDistribution(MINCHILDREN,
                    childrenCount,count);
            System.out.printf("depth = %d, children count is %d, trying to sum to %d\n",
                    depth,childrenCount,count);
            Distribution.printDistribution(childrenSizes);

            for (int childrenSize : childrenSizes) {
                generateDescendents(childrenSize);
            }

        } else {
            // we should really consider the possibility of grandchildren even in this case, but....
            generateChildren(count);
        }

    }

    /**
     * This recursion is lacking XXX.
     *
     * @param count
     */
    void generateDescendents(int count) {
        if (count < MINCHILDREN) {
            System.out.printf("generating %d children for %s\n",count,name);
            generateChildren(count);
        } else if (count > MAXCHILDREN) {
            System.out.printf("generating %d grandchildren* for %s\n", count, name);
            Random r = new Random();
            int childrenCount = MINCHILDREN + r.nextInt(MAXCHILDREN-MINCHILDREN);

            // a better way is to use a latent dirichlet allocation, but....
            int [] childrenSizes = SimpleDistribution.makeDistribution(childrenCount,count);
            System.out.printf("depth = %d, children count is %d, trying to sum to %d\n",
                    depth,childrenCount,count);
            Distribution.printDistribution(childrenSizes);

            for (int i=0; i<childrenSizes.length; i++) {
                Node child = new Node(name+Integer.toString(i+1));
                child.setParent(this);

                // This child will have no children if the value of childrenSizes is 1
                if (childrenSizes[i] > 1) {
                    child.generateDescendents(childrenSizes[i]-1);
                }

            }

        } else {
            // we should really consider the possibility of grandchildren even in this case, but....
            System.out.printf("generating* %d children for %s\n",count,name);
            generateChildren(count);
        }

    }
}
