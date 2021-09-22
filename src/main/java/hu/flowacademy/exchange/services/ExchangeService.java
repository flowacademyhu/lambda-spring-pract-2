package hu.flowacademy.exchange.services;

import hu.flowacademy.exchange.models.ExchangeModel;
import hu.flowacademy.exchange.repositories.ExchangeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;

    public ExchangeModel addExchange(ExchangeModel exchangeModel) {
        return this.exchangeRepository.save(exchangeModel);
    }

    public double exchange(String from, String to, double amount) {
        return this.exchangeRepository.findRateByFromAndTo(from, to) * amount;
    }

    public ExchangeModel update(UUID id, ExchangeModel exchangeModel) {
        return this.exchangeRepository.update(id, exchangeModel);
    }

    public void delete(UUID id) {
        this.exchangeRepository.deleteById(id);
    }
}
