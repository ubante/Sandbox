package com.ubante.bullet.model;

/**
 * Created by Con_0 on 3/19/14.
 */
public class Device {
    Camera camera;
    String modelName;

    Device(String model) {
        modelName = model;
        camera = new Camera();
    }

    Device() {
        this("defaultcameraname");
    }


    void takePhoto() {
        camera.takePhoto();
    }

    void printGallery() {
        camera.print();
    }

    void print() {
        System.out.println(modelName);
    }


    public static void main(String[] args) {
        Device d = new Device("Samsung 17");
        d.print();
        d.printGallery();
        System.out.println("Shooting....");
        d.takePhoto();
        try {
            System.out.println("Saving....");
            Thread.sleep(2000);
        } catch(InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Shooting....");
        d.takePhoto();
        d.printGallery();
    }
}
