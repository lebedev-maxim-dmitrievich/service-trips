package ru.lebedev.servicetrips.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import ru.lebedev.servicetrips.exception.UserNotExistException;
import ru.lebedev.servicetrips.exception.InvalidateDataTripException;
import ru.lebedev.servicetrips.exception.ServiceCarUnavailable;
import ru.lebedev.servicetrips.exception.ServiceUserUnavailable;
import ru.lebedev.servicetrips.response.ErrorResponse;
import ru.lebedev.servicetrips.response.ValidationErrorResponse;
import ru.lebedev.servicetrips.response.ValidationErrorResponseItem;

import javax.persistence.EntityNotFoundException;

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

    @ExceptionHandler(UserNotExistException.class)
    public ResponseEntity<?> carStatusNotAvailableExceptionHandler(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFoundExceptionHandler(Exception e) {
        ErrorResponse response = new ErrorResponse();
        response.setMessage(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ValidationErrorResponse validationErrorResponse = new ValidationErrorResponse();
        e.getFieldErrors().forEach(fieldError -> {
            ValidationErrorResponseItem item = new ValidationErrorResponseItem();
            item.setField(fieldError.getField());
            item.setMessage(fieldError.getDefaultMessage());
            validationErrorResponse.getValidationErrors().add(item);
        });

        return new ResponseEntity<>(validationErrorResponse, HttpStatus.BAD_REQUEST);
    }
}
