package ru.lebedev.servicetrips.request;

import lombok.Data;

@Data
public class CarRequest {

    private String brande;
    private String model;
    private String status;
    private double mileage;
    private int yearProduction;
    private double costPerMinute;
    private String number;
    private byte[] photo;
}
