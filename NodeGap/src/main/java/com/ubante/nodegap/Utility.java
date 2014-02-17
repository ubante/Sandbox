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

        Rock stone = new Granite();
        System.out.println("This is a rock: " + stone.name);
    }
}

class Rock {
    String name;
    float size;
}

class Granite extends Rock {
    String name = "granite";

    Granite() {
        this.name = name;
    }
}
