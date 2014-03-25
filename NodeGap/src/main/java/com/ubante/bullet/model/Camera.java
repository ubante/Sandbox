package com.ubante.bullet.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Con_0 on 3/19/14.
 */
public class Camera {
    List<Photo> gallery = new ArrayList<Photo>();

    Camera() {}

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
        Camera c = new Camera();
        c.print();
        c.takePhoto();
        c.takePhoto();
        c.print();
    }

}
