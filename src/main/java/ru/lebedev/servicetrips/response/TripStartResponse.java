package ru.lebedev.servicetrips.response;

import lombok.Data;
import ru.lebedev.servicetrips.model.enums.TripStatus;

@Data
public class TripStartResponse {

    private Integer id;
    private int userID;
    private int carID;
    private TripStatus status;
    private double costPerMinute;
    private String startTime;
}
