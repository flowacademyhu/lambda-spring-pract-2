package hu.flowacademy.exchange.repositories;

import hu.flowacademy.exchange.models.ExchangeModel;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class ExchangeRepository {
    // UUID -> id, ExchangeModel -> valuta páros
    private final Map<UUID, ExchangeModel> currencies = new HashMap<>();

    public ExchangeModel save(ExchangeModel exchangeModel) {
        UUID id = UUID.randomUUID();
        var newExchangeModel = exchangeModel.toBuilder().id(id).build();
        this.currencies.put(id, newExchangeModel);
        return newExchangeModel;
    }

    public ExchangeModel update(UUID id, ExchangeModel exchangeModel) {
        this.currencies.put(id, exchangeModel);
        return exchangeModel.toBuilder().id(id).build();
    }

    public double findRateByFromAndTo(String from, String to) {
        return this.currencies.values()
                .stream()
                .filter(e -> from.equals(e.getFrom()) && to.equals(e.getTo()))
                .findFirst()
                .orElseThrow()
                .getRate();
    }

    public void deleteById(UUID id) {
        this.currencies.remove(id);
    }
}
