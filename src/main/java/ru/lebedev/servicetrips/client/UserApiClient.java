package ru.lebedev.servicetrips.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.lebedev.servicetrips.model.dto.User;
import ru.lebedev.servicetrips.exception.ServiceCarUnavailable;
import ru.lebedev.servicetrips.exception.ServiceUserUnavailable;

@Service
public class UserApiClient {

    private final String USER_RESOURCE_URL = "http://localhost:8888/api/users";

    public boolean isExist(int userId) throws ServiceUserUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            boolean isExist = restTemplate.getForObject(USER_RESOURCE_URL + "/" + userId + "/exist", boolean.class);

            return isExist;
        } catch (ResourceAccessException e) {
            throw new ServiceUserUnavailable("service users unavailable");
        }
    }

    public void inDrive(int carId) throws ServiceCarUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(USER_RESOURCE_URL + "/" + carId + "/drive/start", User.class);

        } catch (ResourceAccessException e) {
            throw new ServiceCarUnavailable("service users unavailable");
        }
    }

    public void notInDrive(int carId) throws ServiceCarUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.put(USER_RESOURCE_URL + "/" + carId + "/drive/over", User.class);

        } catch (ResourceAccessException e) {
            throw new ServiceCarUnavailable("service users unavailable");
        }
    }
}
