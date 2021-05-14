package ru.lebedev.servicetrips.exception;

public class ServiceCarUnavailable extends Exception {

    public ServiceCarUnavailable() {
    }

    public ServiceCarUnavailable(String message) {
        super(message);
    }

    public ServiceCarUnavailable(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceCarUnavailable(Throwable cause) {
        super(cause);
    }

    public ServiceCarUnavailable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
