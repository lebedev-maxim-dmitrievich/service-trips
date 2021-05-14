package ru.lebedev.servicetrips.mapper;

import org.springframework.stereotype.Service;
import ru.lebedev.servicetrips.model.Trip;
import ru.lebedev.servicetrips.response.CarResponse;
import ru.lebedev.servicetrips.response.TripResponse;
import ru.lebedev.servicetrips.response.UserResponse;

@Service
public class TripMapper {

    public TripResponse mapToTripResponse(Trip trip) {
        TripResponse tripResponse = new TripResponse();

        tripResponse.setId(trip.getId());
        tripResponse.setUserID(trip.getUserID());
        tripResponse.setCarID(trip.getCarID());
        tripResponse.setCarStatus(trip.getCarStatus());
        tripResponse.setCostPerMinute(trip.getCostPerMinute());
        tripResponse.setStartTime(trip.getStartTime());
        tripResponse.setFinishTime(trip.getFinishTime());

        return tripResponse;
    }

    public Trip createTrip(CarResponse carResponse, UserResponse userResponse) {
        Trip trip = new Trip();

        trip.setUserID(userResponse.getId());
        trip.setCarID(carResponse.getId());
        trip.setCostPerMinute(carResponse.getCostPerMinute());
        trip.setCarStatus("Занята");
        trip.setStartTime("");
        trip.setFinishTime("");

        return trip;
    }
}
