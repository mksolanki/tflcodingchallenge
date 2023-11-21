package com.tfl.codingchallenge.road.exception;

/**
 * This is the exception class for no road found.
 */
public class RoadNotFoundException extends RuntimeException {
    public RoadNotFoundException(String message) {
        super(message);
    }
}
