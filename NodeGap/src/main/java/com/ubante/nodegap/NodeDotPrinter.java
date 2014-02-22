package com.ubante.nodegap;

import java.util.ArrayList;
import java.util.List;

/**
 * This will take a node tree and translate it to a digraph in the DOT language.
 * http://en.wikipedia.org/wiki/DOT_language
 */
public class NodeDotPrinter {
    Node root;

    NodeDotPrinter (Node root) {
        this.root = root;
    }




    List<String> getStringArray() {
        List<String> output = new ArrayList<String>();
        output.add("digraph g {");

        for (ParentChildPair pair : root.getParentChildPairs()) {
            String dotLine = String.format("   %s -> %s",pair.parent.name,pair.child.name);
            output.add(dotLine);
        }

        output.add("}");
        return output;
    }

    void print () {
        List<String> output = getStringArray();

        for (String line : output) {
            System.out.println(line);
        }
    }
}
