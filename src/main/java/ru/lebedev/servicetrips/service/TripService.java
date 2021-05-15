package ru.lebedev.servicetrips.service;

import ru.lebedev.servicetrips.exception.ServiceCarUnavailable;
import ru.lebedev.servicetrips.exception.ServiceUserUnavailable;
import ru.lebedev.servicetrips.response.CarResponse;
import ru.lebedev.servicetrips.response.TripResponse;

import java.util.List;

public interface TripService {

    List<CarResponse> getAllAvailableCar();

    TripResponse startTrip(int userID, int carID) throws ServiceCarUnavailable, ServiceUserUnavailable;

    void finishTrip(int tripID);
}
