package app.car_rental.api.controllers;

import app.car_rental.api.dto.DepenseDTO;
import app.car_rental.api.services.DepenseService;
import app.car_rental.data.entities.Depense;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/depenses")
public class DepenseController {

    private final DepenseService depenseService;

    @Autowired
    public DepenseController(DepenseService depenseService) {
        this.depenseService = depenseService;
    }

    @GetMapping
    public ResponseEntity<List<Depense>> getAll() {
        return ResponseEntity.ok(depenseService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Depense> getById(@PathVariable Long id) {
        return ResponseEntity.ok(depenseService.getById(id));
    }

    @GetMapping("/voiture/{voitureId}")
    public ResponseEntity<List<Depense>> getByCar(@PathVariable Long voitureId) {
        return ResponseEntity.ok(depenseService.getByCar(voitureId));
    }

    @GetMapping("/type/{typeId}")
    public ResponseEntity<List<Depense>> getByType(@PathVariable Long typeId) {
        return ResponseEntity.ok(depenseService.getByType(typeId));
    }

    @GetMapping("/total")
    public ResponseEntity<BigDecimal> getTotalByPeriod(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate debut,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin) {
        return ResponseEntity.ok(depenseService.getTotalByPeriod(debut, fin));
    }

    @PostMapping
    public ResponseEntity<Depense> create(@Valid @RequestBody DepenseDTO dto) {
        return ResponseEntity.ok(depenseService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Depense> update(@PathVariable Long id, @Valid @RequestBody DepenseDTO dto) {
        return ResponseEntity.ok(depenseService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        depenseService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
