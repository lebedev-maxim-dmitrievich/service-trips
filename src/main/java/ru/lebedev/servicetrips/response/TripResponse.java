package ru.lebedev.servicetrips.response;

import lombok.Data;

@Data
public class TripResponse {

    private Integer id;
    private int userID;
    private int carID;
    private String carStatus;
    private double costPerMinute;
    private String startTime;
    private String finishTime;
}
