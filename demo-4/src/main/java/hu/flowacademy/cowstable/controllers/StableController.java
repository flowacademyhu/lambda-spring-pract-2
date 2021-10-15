package hu.flowacademy.cowstable.controllers;

import hu.flowacademy.cowstable.dtos.StableDTO;
import hu.flowacademy.cowstable.entities.Stable;
import hu.flowacademy.cowstable.services.StableService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/stable")
public class StableController {
    private final StableService stableService;

    @PostMapping
    public ResponseEntity<?> addStable(@RequestBody StableDTO stableDTO) {
        var savedStable = stableService.addStable(stableDTO);
        // TODO: a szép megoldás itt egy response típus használata, ami leszűkíti a `savedStable` objectet csak `address`-re
        return ResponseEntity.ok(
                Map.of("address", savedStable.getAddress())
        );
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<?> getStableAddress(@PathVariable Long id) {
        var stable = stableService.getStableById(id);
        return ResponseEntity.ok(
                Map.of("address", stable.getAddress())
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStableById(@PathVariable Long id) {
        stableService.deleteStableById(id);
        return ResponseEntity.noContent().build();
    }
}
