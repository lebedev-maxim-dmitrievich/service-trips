package ru.lebedev.servicetrips.model;

import lombok.Data;
import ru.lebedev.servicetrips.response.CarResponse;
import ru.lebedev.servicetrips.response.UserResponse;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userID;
    @Column(name = "car_id")
    private Integer carID;
    @Column(name = "car_status")
    private String carStatus;
    private double costPerMinute;
    private String startTime;
    private String finishTime;
}
