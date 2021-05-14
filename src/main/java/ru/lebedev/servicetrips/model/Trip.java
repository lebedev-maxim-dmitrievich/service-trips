package ru.lebedev.servicetrips.model;

import lombok.Data;

import javax.persistence.*;

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
