package ru.lebedev.servicetrips.client.model;

import lombok.Data;

@Data
public class Car {

    private int id;
    private String brande;
    private String model;
    private String status;
    private double mileage;
    private int yearProduction;
    private double costPerMinute;
    private String number;
    private byte[] photo;
}
