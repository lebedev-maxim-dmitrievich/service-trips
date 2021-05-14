package ru.lebedev.servicetrips.request;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class TripRequest {

    @Min(1)
    private Integer userID;
    @Min(1)
    private Integer carID;
}
