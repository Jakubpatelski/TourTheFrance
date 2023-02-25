package com.example.tourthefrance.Exception;

public class BikerNotFoundException extends RuntimeException {
    public BikerNotFoundException(int id) {
        super("Could not find Biker " + id);
    }
}
