package ru.lebedev.servicetrips.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ValidationErrorResponse {

    List<ValidationErrorResponseItem> validationErrors = new ArrayList<>();
}
