package app.car_rental.api.controllers;

import app.car_rental.api.services.ReferenceService;
import app.car_rental.data.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reference")
public class ReferenceController {

    private final ReferenceService referenceService;

    @Autowired
    public ReferenceController(ReferenceService referenceService) {
        this.referenceService = referenceService;
    }

    @GetMapping("/types-moteur")
    public ResponseEntity<List<RefEngineType>> getEngineTypes() {
        return ResponseEntity.ok(referenceService.getEngineTypes());
    }

    @GetMapping("/transmissions")
    public ResponseEntity<List<RefTransmission>> getTransmissions() {
        return ResponseEntity.ok(referenceService.getTransmissions());
    }

    @GetMapping("/types-carburant")
    public ResponseEntity<List<RefFuelType>> getFuelTypes() {
        return ResponseEntity.ok(referenceService.getFuelTypes());
    }

    @GetMapping("/statuts-voiture")
    public ResponseEntity<List<RefCarStatus>> getCarStatuses() {
        return ResponseEntity.ok(referenceService.getCarStatuses());
    }

    @GetMapping("/modes-paiement")
    public ResponseEntity<List<RefPaymentMethod>> getPaymentMethods() {
        return ResponseEntity.ok(referenceService.getPaymentMethods());
    }
}
