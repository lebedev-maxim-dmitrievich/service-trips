package ru.lebedev.servicetrips.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import ru.lebedev.servicetrips.constant.ApiConstants;
import ru.lebedev.servicetrips.exception.ServiceUserUnavailable;

@Service
public class UserApiClient implements ApiConstants {

    public boolean isExist(int userId) throws ServiceUserUnavailable {
        try {
            RestTemplate restTemplate = new RestTemplate();
            boolean isExist = restTemplate.getForObject(USER_RESOURCE_URL + "/" + userId + "/exist", boolean.class);

            return isExist;
        } catch (ResourceAccessException e) {
            throw new ServiceUserUnavailable("service users unavailable");
        }
    }
}
