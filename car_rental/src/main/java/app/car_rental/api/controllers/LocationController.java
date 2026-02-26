package app.car_rental.api.controllers;

import app.car_rental.api.dto.LocationDTO;
import app.car_rental.api.services.LocationService;
import app.car_rental.data.entities.Rental;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public ResponseEntity<List<Rental>> getAll() {
        return ResponseEntity.ok(locationService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rental> getById(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.getById(id));
    }

    @GetMapping("/actives")
    public ResponseEntity<List<Rental>> getActive() {
        return ResponseEntity.ok(locationService.getActive());
    }

    @GetMapping("/client/{clientId}")
    public ResponseEntity<List<Rental>> getByClient(@PathVariable Long clientId) {
        return ResponseEntity.ok(locationService.getByClient(clientId));
    }

    @PostMapping
    public ResponseEntity<Rental> create(@Valid @RequestBody LocationDTO dto) {
        return ResponseEntity.ok(locationService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rental> update(@PathVariable Long id, @Valid @RequestBody LocationDTO dto) {
        return ResponseEntity.ok(locationService.update(id, dto));
    }

    @PutMapping("/{id}/fin")
    public ResponseEntity<Rental> endRental(@PathVariable Long id) {
        return ResponseEntity.ok(locationService.endRental(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        locationService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
