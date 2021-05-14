package ru.lebedev.servicetrips.response;

import lombok.Data;

@Data
public class CarResponse {

    private int id;
    private String brande;
    private String model;
    private double mileage;
    private String status;
    private int yearProduction;
    private double costPerMinute;
    private String number;
    private byte[] photo;
}
