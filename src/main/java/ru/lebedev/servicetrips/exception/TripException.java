package ru.lebedev.servicetrips.exception;

public class TripException extends Exception{

    public TripException() {
    }

    public TripException(String message) {
        super(message);
    }

    public TripException(String message, Throwable cause) {
        super(message, cause);
    }

    public TripException(Throwable cause) {
        super(cause);
    }

    public TripException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
