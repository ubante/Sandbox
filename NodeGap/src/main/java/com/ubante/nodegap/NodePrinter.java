package com.ubante.nodegap;

/**
 * Print different things statically.
 */
public class NodePrinter {

    /* going with option me

- A (8 children, 50 descendants)
    - A1 (1 children, 1 descendants)
        - A11
     A2 (6 children, 6 descendants)

     */
    static void HorizontalTree(Node root, int offset) {
        for (int i=0; i<offset; i++) {
            System.out.printf("   ");
        }
        if (root.getDescendantCount() > 0) {
            System.out.printf("- %s (%d children, %d descendants)\n",root.name,
                    root.getChildrenCount(),root.getDescendantCount());
        } else {
            System.out.printf("- %s\n",root.name);
        }
        for (Node child : root.children) {
//            System.out.println("| + " + child.name);
            HorizontalTree(child, offset+1);
        }
    }

    static void HorizontalTree(Node root) {
        HorizontalTree(root,0);
    }


    public void PrintPretty(String indent, boolean last)
    {
        System.out.printf("%s",indent);
        if (last)
        {
            System.out.printf("\\-");
//            Console.Write("\\-");
            indent += "  ";
        }
        else
        {
            System.out.printf("|-");
//            Console.Write("|-");
            indent += "| ";
        }
        System.out.println();
//        Console.WriteLine(Name);
//
//        for (int i = 0; i < Children.Count; i++)
//            Children[i].PrintPretty(indent, i == Children.Count - 1);
    }
}

    /* option 1
A
+-B
| +-C
| +-D
|   +-E
+-F
  +-G
     */

    /* option 2
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
     */

/* option 3
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
 */

/* option 4
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