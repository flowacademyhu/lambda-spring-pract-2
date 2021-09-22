package hu.flowacademy.exchange.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Builder(toBuilder = true)
@Getter
@ToString
public class ExchangeModel {
    private final UUID id;
    private final String from;
    private final String to;
    private final double rate;
}