package ru.lebedev.servicetrips.exception;

public class InvalidateDataTripException extends Throwable {

    public InvalidateDataTripException() {
    }

    public InvalidateDataTripException(String message) {
        super(message);
    }

    public InvalidateDataTripException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidateDataTripException(Throwable cause) {
        super(cause);
    }

    public InvalidateDataTripException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
