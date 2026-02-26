package app.car_rental.api.services;

import app.car_rental.data.entities.*;
import app.car_rental.data.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReferenceService {

    private final RefEngineTypeRepository engineTypeRepository;
    private final RefTransmissionRepository transmissionRepository;
    private final RefFuelTypeRepository fuelTypeRepository;
    private final RefCarStatusRepository carStatusRepository;
    private final RefPaymentMethodRepository paymentMethodRepository;

    @Autowired
    public ReferenceService(RefEngineTypeRepository engineTypeRepository,
                            RefTransmissionRepository transmissionRepository,
                            RefFuelTypeRepository fuelTypeRepository,
                            RefCarStatusRepository carStatusRepository,
                            RefPaymentMethodRepository paymentMethodRepository) {
        this.engineTypeRepository = engineTypeRepository;
        this.transmissionRepository = transmissionRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.carStatusRepository = carStatusRepository;
        this.paymentMethodRepository = paymentMethodRepository;
    }

    public List<RefEngineType> getEngineTypes() {
        return engineTypeRepository.findAll();
    }

    public List<RefTransmission> getTransmissions() {
        return transmissionRepository.findAll();
    }

    public List<RefFuelType> getFuelTypes() {
        return fuelTypeRepository.findAll();
    }

    public List<RefCarStatus> getCarStatuses() {
        return carStatusRepository.findAll();
    }

    public List<RefPaymentMethod> getPaymentMethods() {
        return paymentMethodRepository.findAll();
    }
}
