package app.car_rental.api.controllers;

import app.car_rental.api.dto.VenteDTO;
import app.car_rental.api.services.VenteService;
import app.car_rental.data.entities.Sale;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventes")
public class VenteController {

    private final VenteService venteService;

    @Autowired
    public VenteController(VenteService venteService) {
        this.venteService = venteService;
    }

    @GetMapping
    public ResponseEntity<List<Sale>> getAll() {
        return ResponseEntity.ok(venteService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sale> getById(@PathVariable Long id) {
        return ResponseEntity.ok(venteService.getById(id));
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Sale>> getByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(venteService.getByClient(clientId));
    }

    @PostMapping
    public ResponseEntity<Sale> create(@Valid @RequestBody VenteDTO dto) {
        return ResponseEntity.ok(venteService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sale> update(@PathVariable Long id, @Valid @RequestBody VenteDTO dto) {
        return ResponseEntity.ok(venteService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        venteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
