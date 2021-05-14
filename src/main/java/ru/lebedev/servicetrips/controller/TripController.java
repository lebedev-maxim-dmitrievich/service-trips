package ru.lebedev.servicetrips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.servicetrips.exception.InvalidateDataTripException;
import ru.lebedev.servicetrips.exception.ServiceCarUnavailable;
import ru.lebedev.servicetrips.exception.ServiceUserUnavailable;
import ru.lebedev.servicetrips.request.TripRequest;
import ru.lebedev.servicetrips.response.TripResponse;
import ru.lebedev.servicetrips.service.impl.TripServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final TripServiceImpl tripServiceImpl;

    @Autowired
    public TripController(TripServiceImpl tripServiceImpl) {
        this.tripServiceImpl = tripServiceImpl;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid TripRequest tripRequest, Errors errors) throws InvalidateDataTripException, ServiceCarUnavailable, ServiceUserUnavailable {
        if (errors.hasErrors()) {
            throw new InvalidateDataTripException("incorrect data");
        }
        TripResponse response = tripServiceImpl.startTrip(tripRequest.getUserID(), tripRequest.getCarID());

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
