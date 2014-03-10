package com.ubante.hadeck;

/**
 * Created by Con_0 on 3/9/14.
 */
public class HandTooLargeException extends Exception {
    HandTooLargeException(String message) {
        super(message);
    }

//    HandTooLargeException() {
//        String message = "You have exceeded the defined size of this hand\n";
//        throw new HandTooLargeException(message);
//    }
}
