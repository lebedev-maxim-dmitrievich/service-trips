package ru.lebedev.servicetrips.model;

import lombok.Data;
import ru.lebedev.servicetrips.model.enums.TripStatus;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "trips")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "car_id")
    private Integer carId;
    @Enumerated(value = EnumType.STRING)
    private TripStatus status;
    @Column(name = "cost_per_minute")
    private double costPerMinute;
    private Date startTime;
    private Date finishTime;
    private double cost;
}
