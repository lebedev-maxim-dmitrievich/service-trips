package ru.lebedev.servicetrips;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.lebedev.servicetrips.constant.ApiConstants;

import java.time.LocalDate;
import java.util.Date;

@SpringBootApplication
public class ServiceTripsApplication implements ApiConstants {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(ServiceTripsApplication.class, args);
    }
}

