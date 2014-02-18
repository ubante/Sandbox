package com.ubante.nodegap;

import java.util.List;

/**
 * Print different things statically.
 option 1
 A
 +-B
 | +-C
 | +-D
 |   +-E
 +-F
 +-G


 option 2
 \-root
 \-child
 |-child
 \-child
 |-child
 |-child
 \-child
 |-child
 |-child
 | |-child
 | \-child
 |   |-child
 |   |-child
 |   |-child
 |   \-child
 |     \-child
 |       \-child
 \-child


 option 3
 + top : 123
 | + Node 1 : 29
 |   | + subnode 0 : 90
 |   |     + sdhasj : 232
 |   | + subnode 1 : 38
 |   | + subnode 2 : 49
 |   | + subnode 8 : 39
 |     + subnode 9 : 47
 + Node 2 : 51
 | + subnode 0 : 89
 |     + sdhasj : 232
 | + subnode 1 : 33
 + subnode 3 : 57


 option 4
 +- 43(l:0, d:1)
 |  +- 32(l:1, d:3)
 |  |  +- 10(l:2, d:0)
 |  |  |  +- <null>
 |  |  |  +- <null>
 |  |  +- 40(l:2, d:2)
 |  |  |  +- <null>
 |  |  |  +- 41(l:3, d:0)
 |  |  |  |  +- <null>
 |  |  |  |  +- <null>
 |  +- 75(l:1, d:5)
 */
public class NodePrinter {

    /* going with option me

- A (8 children, 50 descendants)
    - A1 (1 children, 1 descendants)
        - A11
     A2 (6 children, 6 descendants)

     */
    private static void HorizontalTree(Node root, int offset,
                boolean doPrintLeaves,
                boolean doPrintGrandparentsOnly,
                boolean doConcisely) {
        int childrenCount = root.getChildrenCount();
        int descendantCount = root.getDescendantCount();
        boolean doPrintParentsOnly = !doPrintLeaves;

        // Return if this node is not a grandparent and want to print grandparents only.
        // ie print only parents of parents and above.
        if ((descendantCount == childrenCount) && doPrintGrandparentsOnly) { return; }

        // Return if this node is a leaf and we don't want to print leaves.
        if (childrenCount==0 && doPrintParentsOnly) { return; }

        for (int i=0; i<offset; i++) {
            System.out.printf("   ");
        }
        if (descendantCount > 0) {
            if (doConcisely) {
                System.out.printf("- (%d)\n",descendantCount);
            } else {
                if (descendantCount > childrenCount ) {
                    System.out.printf("- %s (%d c / %d d)\n",root.name,childrenCount,descendantCount);
                } else {
                    System.out.printf("- %s (%d c)\n",root.name,childrenCount);
                }
            }
        } else {
            System.out.printf("- %s\n",root.name);
        }
        for (Node child : root.children) {
            HorizontalTree(child,offset+1,doPrintLeaves,doPrintGrandparentsOnly,doConcisely);
        }
    }

    static void HorizontalTree(Node root) {
        HorizontalTree(root,0,true,false,false);
    }

    static void HorizontalTreeVerbose(Node root) {
        HorizontalTree(root,0,true,false,false);
    }
    // this is the same as printing parents only
    static void HorizontalTreeNoLeaves(Node root) {
        HorizontalTree(root,0,false,false,false);
    }

    static void HorizontalTreeGrandparentsOnly(Node root) {
        HorizontalTree(root,0,false,true,false);
    }

    // Print just grandparents and skip names and childrencount
    static void HorizontalTreeConcise(Node root) {
        HorizontalTree(root,0,false,false,true);
    }

    static String getSpacePadding(Node n, int spacesPerWidth) {
        String padding = "";
        float numberOfWidths = (n.printWidth-1)/2f;

        for (int i=0; i<(numberOfWidths*spacesPerWidth); i++) {
            padding += " ";
        }

        return padding;
    }

    static String getDashPadding(Node leftNode, Node rightNode,
                int width, int spacesPerWidth) {
        String padding = "";
        int leftWidth = leftNode.printWidth;
        int rightWidth = rightNode.printWidth;
        float totalWidthOfNonSpaces = width - (leftWidth+rightWidth)/2 - 1;

        // The name takes a width so the dash paddings are
        float dashPaddingSize = (totalWidthOfNonSpaces - 1)*spacesPerWidth/2;
        for (int i=0; i<dashPaddingSize; i++) {
            padding += "-";
        }

//        System.out.println();
//        System.out.println("leftwidth: " + leftWidth);
//        System.out.println("rightwidth: " + rightWidth);
//        System.out.println("width: " + width);
//        System.out.println("totalwidthofnonspaces: " + totalWidthOfNonSpaces);
//        System.out.println("padding: " + padding);
//        System.out.println();


        return padding;
//        return "XXXXXX";
    }


    static int VerticalTree(Node root) {
        int spacesPerWidthUnit = 13; // has to be a better way
        int immediateWidth = root.getChildrenCount(); // units of nodes, eg 5 nodes wide
        int width = immediateWidth;
        System.out.printf("%s(%d) \n", root.name, root.getDescendantCount());

        for (Node child : root.children) {
            System.out.printf("%s(%d) ",child.name,child.getDescendantCount());
        }
        System.out.println();

        // Print only grandparents
        for (Node child : root.children) {
            if (child.getChildrenCount() != child.getDescendantCount()) {
                child.printWidth = VerticalTree(child);
                // we either subtract 1 from width here or from below
                width += child.printWidth-1;
            }
        }

//        System.out.println("\nwidth is " + width + " immediate is " + immediateWidth);

        // We'll use an "L" to show where the subtrees end.
        // The children's row
        for (Node child : root.children) {
            System.out.printf("%s",getSpacePadding(child,spacesPerWidthUnit));
            System.out.printf("%7s(%4d)",child.name,child.getDescendantCount());
            System.out.printf("%s",getSpacePadding(child,spacesPerWidthUnit));
        }
        System.out.println("L");
        for (Node child : root.children) {
            System.out.printf("%s",getSpacePadding(child,spacesPerWidthUnit));
            System.out.printf("       |     ");
            System.out.printf("%s",getSpacePadding(child,spacesPerWidthUnit));
        }
        System.out.println("L");
        for (Node child : root.children) {
            System.out.printf("%s",getSpacePadding(child,spacesPerWidthUnit));
            System.out.printf("       |     ");
            System.out.printf("%s",getSpacePadding(child,spacesPerWidthUnit));
        }
        System.out.println("L");

        // The parent's row
        // First the leading spaces
        Node firstChild = root.children.get(0);
        Node lastChild = root.children.get(root.children.size()-1);

//        System.out.println("width of first child: " + firstChild.printWidth);
//        System.out.println("width of last  child: " + lastChild.printWidth);

        System.out.println();
        System.out.printf("%s",getSpacePadding(firstChild,spacesPerWidthUnit));
        for (int i=0; i<spacesPerWidthUnit/2+1; i++) {
            System.out.printf(" ");
        }

        // Then the leading dashes
        String dashes = getDashPadding(firstChild, lastChild, width, spacesPerWidthUnit);
        System.out.printf("%s", dashes);
//        for (int i=0; i<(spacesPerWidthUnit*(immediateWidth-2)/2); i++) {
//            System.out.printf("-");
//        }
        System.out.printf("%7s(%4d)", root.name, root.getDescendantCount());

        // Then the trailing dashes
        System.out.printf("%s", dashes);
//        for (int i=0; i<(spacesPerWidthUnit*(immediateWidth-2)/2+1); i++) {
//            System.out.printf("-");
//        }
        // Odd immediate widths are missing a dash
        if (Math.round((immediateWidth+1)/2) != Math.round(immediateWidth/2)) {
            System.out.printf("-");
        }
        // Then the trailing spaces (is this needed?)
        for (int i=0; i<spacesPerWidthUnit/2-1; i++) {
            System.out.printf(" ");
        }
        System.out.println("L");

        // we either subtract 1 from width here or from above
        return width;
    }

}


/**
 *
X1(   0)     X2(   0)     X3(   0)      W(   5)
 |            |            |            |
 |            |            |            |
 -------------      X(   9)--------------     Y(   4)      T(   0)
                    |            	          |            |
                    |            	          |            |
                    -------------      Z(  16)--------------

 */












