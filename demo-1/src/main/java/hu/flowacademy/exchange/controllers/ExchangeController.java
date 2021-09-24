package hu.flowacademy.exchange.controllers;

import hu.flowacademy.exchange.models.ExchangeModel;
import hu.flowacademy.exchange.services.ExchangeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/exchange")
@AllArgsConstructor
public class ExchangeController {
    private final ExchangeService exchangeService;

    @PostMapping("/")
    public ResponseEntity<ExchangeModel> addExchange(@RequestBody ExchangeModel exchangeModel) {
        var savedExchange = this.exchangeService.addExchange(exchangeModel);
        return ResponseEntity.ok(savedExchange);
    }

    // GET /api/exchange/?from=EUR&to=HUF&amount=5000
    @GetMapping("/")
    public ResponseEntity<Double> exchange(@RequestParam String from,
                                           @RequestParam String to,
                                           @RequestParam double amount) {
        var exchanged = this.exchangeService.exchange(from, to, amount);
        return ResponseEntity.ok(exchanged);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExchangeModel> update(@PathVariable UUID id, @RequestBody ExchangeModel exchangeModel) {
        return ResponseEntity.ok(
                this.exchangeService.update(id, exchangeModel)
        );
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) { // 204 - No Content
        this.exchangeService.delete(id);
    }
}
