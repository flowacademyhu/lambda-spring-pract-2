package hu.flowacademy.cowstable.models;

import lombok.Data;

@Data
public class ErrorModel {
    private final String message;
    private final String data;
}
