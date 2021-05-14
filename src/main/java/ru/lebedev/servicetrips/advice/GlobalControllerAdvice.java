package ru.lebedev.servicetrips.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import ru.lebedev.servicetrips.exception.InvalidateDataTripException;
import ru.lebedev.servicetrips.exception.ServiceCarUnavailable;
import ru.lebedev.servicetrips.exception.ServiceUserUnavailable;
import ru.lebedev.servicetrips.response.ErrorResponse;

@ControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(ServiceCarUnavailable.class)
    public ResponseEntity<?> serviceCarUnavailableHandler(ServiceCarUnavailable e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(ServiceUserUnavailable.class)
    public ResponseEntity<?> serviceUserUnavailableHandler(ServiceUserUnavailable e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(InvalidateDataTripException.class)
    public ResponseEntity<?> invalidateDataTripExceptionHandler(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpClientErrorException.class)
    public ResponseEntity<?> httpClientErrorExceptionHandler(HttpClientErrorException e) {
        return new ResponseEntity<>(e.getResponseBodyAsString(), HttpStatus.BAD_REQUEST);
    }
}
