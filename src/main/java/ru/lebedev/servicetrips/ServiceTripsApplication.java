package ru.lebedev.servicetrips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.lebedev.servicetrips.constant.TripServiceImplConstants;

@SpringBootApplication
public class ServiceTripsApplication implements TripServiceImplConstants {

    public static void main(String[] args) {
        SpringApplication.run(ServiceTripsApplication.class, args);
    }
}

