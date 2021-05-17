package ru.lebedev.servicetrips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.lebedev.servicetrips.exception.TripException;
import ru.lebedev.servicetrips.exception.UserNotExistException;
import ru.lebedev.servicetrips.exception.ServiceCarUnavailable;
import ru.lebedev.servicetrips.exception.ServiceUserUnavailable;
import ru.lebedev.servicetrips.request.TripRequest;
import ru.lebedev.servicetrips.response.TripFinishResponse;
import ru.lebedev.servicetrips.response.TripStartResponse;
import ru.lebedev.servicetrips.service.TripService;
import ru.lebedev.servicetrips.service.impl.TripServiceImpl;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/trips")
public class TripController {

    private final TripService tripService;

    @Autowired
    public TripController(TripServiceImpl tripService) {
        this.tripService = tripService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTrip(@RequestBody @Valid TripRequest tripRequest) throws ServiceCarUnavailable, ServiceUserUnavailable, UserNotExistException, TripException {
        TripStartResponse response = tripService.startTrip(tripRequest);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/finish")
    public ResponseEntity<?> finishTrip(@PathVariable Integer id) throws ServiceCarUnavailable {
        TripFinishResponse response = tripService.finishTrip(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
