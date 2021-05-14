package ru.lebedev.servicetrips.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.lebedev.servicetrips.constant.TripServiceImplConstants;
import ru.lebedev.servicetrips.exception.ServiceCarUnavailable;
import ru.lebedev.servicetrips.exception.ServiceUserUnavailable;
import ru.lebedev.servicetrips.mapper.TripMapper;
import ru.lebedev.servicetrips.model.Trip;
import ru.lebedev.servicetrips.repository.TripRepository;
import ru.lebedev.servicetrips.response.CarResponse;
import ru.lebedev.servicetrips.response.TripResponse;
import ru.lebedev.servicetrips.response.UserResponse;
import ru.lebedev.servicetrips.service.TripService;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class TripServiceImpl implements TripService, TripServiceImplConstants {

    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }

    @Override
    public List<CarResponse> getAllCar() throws ServiceCarUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CarResponse[] carResponses = restTemplate.getForObject(CAR_RESOURCE_URL, CarResponse[].class);
            List<CarResponse> response = Arrays.asList(carResponses);

            return response;
        } catch (ResourceAccessException e) {
            throw new ServiceCarUnavailable("service car unavailable");
        }
    }

    @Override
    public List<CarResponse> getAllAvailableCar() {
        return null;
    }

    @Override
    public TripResponse startTrip(int userID, int carID) throws ServiceCarUnavailable, ServiceUserUnavailable {
        Trip trip = tripMapper.createTrip(getCar(carID), getUser(userID));
        tripRepository.save(trip);
        System.out.println(trip);
        TripResponse response = tripMapper.mapToTripResponse(trip);

        return response;
    }

    @Override
    public void finishTrip(int tripID) {

    }

    private CarResponse getCar(int carID) throws ServiceCarUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            CarResponse response = restTemplate.getForObject(CAR_RESOURCE_URL + "/" + carID, CarResponse.class);

            return response;
        } catch (ResourceAccessException e) {
            throw new ServiceCarUnavailable("service cars unavailable");
        }
    }

    private UserResponse getUser(int userID) throws ServiceUserUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            UserResponse response = restTemplate.getForObject(USER_RESOURCE_URL + "/" + userID, UserResponse.class);

            return response;
        } catch (ResourceAccessException e) {
            throw new ServiceUserUnavailable("service users unavailable");
        }
    }
}
