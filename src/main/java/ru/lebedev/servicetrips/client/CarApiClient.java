package ru.lebedev.servicetrips.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.lebedev.servicetrips.exception.ServiceCarUnavailable;
import ru.lebedev.servicetrips.model.dto.Car;

@Service
public class CarApiClient {

    private final String CAR_RESOURCE_URL = "http://localhost:8080/api/cars";

    public Car getById(int carId) throws ServiceCarUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            Car response = restTemplate.getForObject(CAR_RESOURCE_URL + "/" + carId, Car.class);

            return response;
        } catch (ResourceAccessException e) {
            throw new ServiceCarUnavailable("service cars unavailable");
        }
    }

    public void bookCar(int carId) throws ServiceCarUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(CAR_RESOURCE_URL + "/" + carId + "/book", Car.class);

        } catch (ResourceAccessException e) {
            throw new ServiceCarUnavailable("service cars unavailable");
        }
    }

    public void freeCar(int carId) throws ServiceCarUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(CAR_RESOURCE_URL + "/" + carId + "/free", Car.class);

        } catch (ResourceAccessException e) {
            throw new ServiceCarUnavailable("service cars unavailable");
        }
    }

    public void repairCar(int carId) throws ServiceCarUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(CAR_RESOURCE_URL + "/" + carId + "/repair", Car.class);

        } catch (ResourceAccessException e) {
            throw new ServiceCarUnavailable("service cars unavailable");
        }
    }
}