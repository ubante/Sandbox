package com.ubante.hadeck;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Con_0 on 3/9/14.
 */

public class NameSort {
    public static void main(String[] args) {
        Name nameArray[] = {
                new Name("John", "Smith"),
                new Name("Karl", "Ng"),
                new Name("Jeff", "Smith"),
                new Name("Tom", "Rich")
        };

        List<Name> names = Arrays.asList(nameArray);
        Collections.sort(names);
        System.out.println(names);
    }
}

