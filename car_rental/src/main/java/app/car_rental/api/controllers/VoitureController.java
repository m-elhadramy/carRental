package app.car_rental.api.controllers;

import app.car_rental.api.dto.VoitureDTO;
import app.car_rental.api.services.VoitureService;
import app.car_rental.data.entities.Car;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voitures")
public class VoitureController {

    private final VoitureService voitureService;

    @Autowired
    public VoitureController(VoitureService voitureService) {
        this.voitureService = voitureService;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(voitureService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getById(@PathVariable Long id) {
        return ResponseEntity.ok(voitureService.getById(id));
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Car>> getAvailable() {
        return ResponseEntity.ok(voitureService.getAvailable());
    }

    @PostMapping
    public ResponseEntity<Car> create(@Valid @RequestBody VoitureDTO dto) {
        return ResponseEntity.ok(voitureService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Car> update(@PathVariable Long id, @Valid @RequestBody VoitureDTO dto) {
        return ResponseEntity.ok(voitureService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        voitureService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
