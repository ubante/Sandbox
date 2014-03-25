package com.ubante.bullet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Nuke this soon.
 */
public class DefunctCamera {
    List<Photo> gallery = new ArrayList<Photo>();

    DefunctCamera() {}

    void takePhoto() {
        gallery.add(new Photo());
    }

    void print() {
        System.out.printf("There are %d photos in the gallery\n",gallery.size());
        for (Photo p : gallery) {
            p.print();
        }
    }

    public static void main(String[] args) {
        DefunctCamera c = new DefunctCamera();
        c.print();
        c.takePhoto();
        c.takePhoto();
        c.print();
    }

}
