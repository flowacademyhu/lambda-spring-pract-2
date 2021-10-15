package hu.flowacademy.cowstable.controllers;

import hu.flowacademy.cowstable.dtos.CowDTO;
import hu.flowacademy.cowstable.entities.Cow;
import hu.flowacademy.cowstable.services.CowService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cow")
@Slf4j
@AllArgsConstructor
public class CowController {
    private final CowService cowService;

    @PostMapping
    public ResponseEntity<Cow> addCow(@RequestBody @Valid CowDTO cowDTO) {
        return new ResponseEntity<>(cowService.addCow(cowDTO), HttpStatus.CREATED);
    }
}
