package ru.lebedev.servicetrips.response;

import lombok.Data;
import ru.lebedev.servicetrips.model.enums.TripStatus;

@Data
public class TripFinishResponse {

    private Integer id;
    private int userID;
    private int carID;
    private TripStatus status;
    private double costPerMinute;
    private String startTime;
    private String finishTime;
    private double cost;
}
