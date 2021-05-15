package ru.lebedev.servicetrips.service;

import ru.lebedev.servicetrips.exception.UserNotExistException;
import ru.lebedev.servicetrips.exception.ServiceCarUnavailable;
import ru.lebedev.servicetrips.exception.ServiceUserUnavailable;
import ru.lebedev.servicetrips.request.TripRequest;
import ru.lebedev.servicetrips.response.TripFinishResponse;
import ru.lebedev.servicetrips.response.TripStartResponse;

public interface TripService {

    TripStartResponse startTrip(TripRequest tripRequest) throws ServiceCarUnavailable, ServiceUserUnavailable, UserNotExistException;

    TripFinishResponse finishTrip(int tripId) throws ServiceCarUnavailable;
}
