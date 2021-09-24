package hu.flowacademy.exchange.services;

import hu.flowacademy.exchange.models.ExchangeModel;
import hu.flowacademy.exchange.repositories.ExchangeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
public class ExchangeServiceTest {

    @Mock
    private ExchangeRepository mockRepo;

    @InjectMocks
    private ExchangeService exchangeService;

    @Test
    public void testSave() {
        // given
        var exchangeModel = ExchangeModel.builder()
                .from("EUR")
                .to("HUF")
                .rate(352.77)
                .build();

        // save mockolása
        var randomUuid = UUID.randomUUID();
        when(mockRepo.save(any())).thenReturn(
                exchangeModel.toBuilder().id(randomUuid).build()
        );

        // when
        var savedExchange = exchangeService.addExchange(exchangeModel);

        // then
        assertEquals(randomUuid, savedExchange.getId());
    }

    @Test
    public void testDelete() {
         // given
        doNothing().when(mockRepo).deleteById(any()); // any() matcher

        // when
        exchangeService.delete(UUID.randomUUID());

        // then
        verify(mockRepo).deleteById(any());
    }

    @Test
    public void testExchange() {
        // given
        when(mockRepo.findRateByFromAndTo(eq("EUR"), eq("HUF"))).thenReturn(350.0);

        // when
        var exchanged = exchangeService.exchange("EUR", "HUF", 10);

        // then
        assertEquals(10 * 350.0, exchanged);
    }
}
