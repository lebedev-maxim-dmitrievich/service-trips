package ru.lebedev.servicetrips.mapper;

import org.springframework.stereotype.Service;
import ru.lebedev.servicetrips.model.Trip;
import ru.lebedev.servicetrips.response.TripFinishResponse;
import ru.lebedev.servicetrips.response.TripStartResponse;

@Service
public class TripMapper {

    public TripStartResponse mapToTripStartResponse(Trip trip) {
        TripStartResponse tripResponse = new TripStartResponse();

        tripResponse.setId(trip.getId());
        tripResponse.setUserId(trip.getUserId());
        tripResponse.setCarId(trip.getCarId());
        tripResponse.setStatus(trip.getStatus());
        tripResponse.setCostPerMinute(trip.getCostPerMinute());
        tripResponse.setStartTime(trip.getStartTime().toLocaleString());

        return tripResponse;
    }

    public TripFinishResponse mapToTripFinishResponse(Trip trip) {
        TripFinishResponse tripResponse = new TripFinishResponse();

        tripResponse.setId(trip.getId());
        tripResponse.setUserId(trip.getUserId());
        tripResponse.setCarId(trip.getCarId());
        tripResponse.setStatus(trip.getStatus());
        tripResponse.setCostPerMinute(trip.getCostPerMinute());
        tripResponse.setStartTime(trip.getStartTime().toLocaleString());
        tripResponse.setFinishTime(trip.getFinishTime().toLocaleString());
        tripResponse.setCost(trip.getCost());

        return tripResponse;
    }
}
