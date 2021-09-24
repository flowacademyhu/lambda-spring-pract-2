package hu.flowacademy.exchange;

import hu.flowacademy.exchange.models.ExchangeModel;
import hu.flowacademy.exchange.repositories.ExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExchangeApplication {
    private final static Logger logger = LoggerFactory.getLogger(ExchangeApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(ExchangeApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ExchangeRepository exchangeRepository) {
        logger.info("Adding initial data...");
        return (args) -> {
            exchangeRepository.save(ExchangeModel.builder()
                    .from("EUR")
                    .to("HUF")
                    .rate(352.77)
                    .build()
            );
            exchangeRepository.save(ExchangeModel.builder()
                    .from("HUF")
                    .to("EUR")
                    .rate(1 / 352.77)
                    .build()
            );
        };
    }
}
