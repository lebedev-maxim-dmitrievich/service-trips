package ru.lebedev.servicetrips.request;

import lombok.Data;

import javax.validation.constraints.Min;

@Data
public class TripRequest {

    @Min(1)
    private Integer userId;
    @Min(1)
    private Integer carId;
}
