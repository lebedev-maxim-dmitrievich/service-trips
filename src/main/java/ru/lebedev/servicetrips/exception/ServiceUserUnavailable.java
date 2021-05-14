package ru.lebedev.servicetrips.exception;

public class ServiceUserUnavailable extends Throwable {

    public ServiceUserUnavailable() {
    }

    public ServiceUserUnavailable(String message) {
        super(message);
    }

    public ServiceUserUnavailable(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceUserUnavailable(Throwable cause) {
        super(cause);
    }

    public ServiceUserUnavailable(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
