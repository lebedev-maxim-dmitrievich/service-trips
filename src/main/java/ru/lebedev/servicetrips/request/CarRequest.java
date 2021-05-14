package ru.lebedev.servicetrips.request;

import lombok.Data;

@Data
public class CarRequest {

    private Integer id;
    private String brande;
    private String model;
    private double mileage;
    private int yearProduction;
    private double costPerMinute;
    private String number;
    private byte[] photo;
}
