package ru.lebedev.servicetrips.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.lebedev.servicetrips.client.CarApiClient;
import ru.lebedev.servicetrips.client.UserApiClient;
import ru.lebedev.servicetrips.client.model.User;
import ru.lebedev.servicetrips.exception.UserNotExistException;
import ru.lebedev.servicetrips.exception.ServiceCarUnavailable;
import ru.lebedev.servicetrips.exception.ServiceUserUnavailable;
import ru.lebedev.servicetrips.mapper.TripMapper;
import ru.lebedev.servicetrips.model.Trip;
import ru.lebedev.servicetrips.model.enums.TripStatus;
import ru.lebedev.servicetrips.repository.TripRepository;
import ru.lebedev.servicetrips.request.TripRequest;
import ru.lebedev.servicetrips.response.TripFinishResponse;
import ru.lebedev.servicetrips.response.TripStartResponse;
import ru.lebedev.servicetrips.service.TripService;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final TripMapper tripMapper;
    private final CarApiClient carApiClient;
    private final UserApiClient userApiClient;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository, TripMapper tripMapper, CarApiClient carApiClient, UserApiClient userApiClient) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
        this.carApiClient = carApiClient;
        this.userApiClient = userApiClient;
    }

    @Override
    @Transactional
    public TripStartResponse startTrip(TripRequest tripRequest) throws ServiceCarUnavailable, ServiceUserUnavailable, UserNotExistException {
        int userId = tripRequest.getUserId();
        int carId = tripRequest.getCarId();

        boolean userIsExist = userApiClient.isExist(userId);
        if (!userIsExist) {
            throw new UserNotExistException("user not exist");
        }

        //TODO сделать одновременно запросы
        carApiClient.bookCar(carId);
        userApiClient.inDrive(userId);

        Trip trip = createTrip(userId, carId);

        tripRepository.save(trip);
        TripStartResponse response = tripMapper.mapToTripStartResponse(trip);

        return response;
    }

    @Override
    @Transactional
    public TripFinishResponse finishTrip(int tripId) throws ServiceCarUnavailable {
        Trip trip = endTrip(tripId);

        int userId = trip.getUserId();
        int carId = trip.getCarId();

        userApiClient.notInDrive(userId);
        carApiClient.freeCar(carId);

        tripRepository.save(trip);
        TripFinishResponse response = tripMapper.mapToTripFinishResponse(trip);

        return response;
    }

    private Trip createTrip(int userId, int carId) throws ServiceCarUnavailable {
        Date currentDate = new Date();

        Trip trip = new Trip();
        trip.setUserId(userId);
        trip.setCarId(carId);
        trip.setCostPerMinute(carApiClient.getById(carId).getCostPerMinute());
        trip.setStartTime(currentDate);
        trip.setStatus(TripStatus.IN_DRIVE);

        return trip;
    }

    private Trip endTrip(int tripId) {
        Date currentDate = new Date();

        try {
            Trip trip = tripRepository.getOne(tripId);
            trip.setFinishTime(currentDate);
            double differenceInMinute = ((trip.getFinishTime().getTime() - trip.getStartTime().getTime()) / 60000);
            trip.setCost(differenceInMinute * trip.getCostPerMinute());
            trip.setStatus(TripStatus.IS_OVER);

            return trip;
        } catch (EntityNotFoundException e) {
            throw new EntityNotFoundException("trip not found");
        }
    }
}
