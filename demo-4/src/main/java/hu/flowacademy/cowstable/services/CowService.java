package hu.flowacademy.cowstable.services;

import hu.flowacademy.cowstable.dtos.CowDTO;
import hu.flowacademy.cowstable.entities.Cow;
import hu.flowacademy.cowstable.repositories.CowRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CowService {
    private final StableService stableService;
    private final CowRepository cowRepository;

    public Cow addCow(CowDTO cowDTO) {
        var stable = stableService.getStableById(cowDTO.getStableId());

        var cow = new Cow(null, cowDTO.getSerialId(), cowDTO.getAge(), stable);

        return cowRepository.save(cow);
    }
}
