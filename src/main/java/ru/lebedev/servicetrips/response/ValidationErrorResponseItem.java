package ru.lebedev.servicetrips.response;

import lombok.Data;

@Data
public class ValidationErrorResponseItem {

    private String field;
    private String message;
}
