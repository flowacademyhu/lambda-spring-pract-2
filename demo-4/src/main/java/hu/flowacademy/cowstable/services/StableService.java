package hu.flowacademy.cowstable.services;

import hu.flowacademy.cowstable.dtos.StableDTO;
import hu.flowacademy.cowstable.entities.Stable;
import hu.flowacademy.cowstable.repositories.StableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class StableService {
    private final StableRepository stableRepository;

    public Stable addStable(StableDTO stableDTO) {
        // BeanUtils.copyProperties(stableDTO, stable);
        return stableRepository.save(
                new Stable(null, stableDTO.getAddress(), new ArrayList<>())
        );
    }

    public Stable getStableById(Long id) {
        return stableRepository.findById(id).orElseThrow();
    }

    public void deleteStableById(Long id) {
        if(!stableRepository.existsById(id)) {
            throw new NoSuchElementException();
        }
        stableRepository.deleteById(id);
    }
}
