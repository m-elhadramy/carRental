package app.car_rental.api.services;

import app.car_rental.api.dto.VoitureDTO;
import app.car_rental.api.exceptions.ResourceNotFoundException;
import app.car_rental.data.entities.Car;
import app.car_rental.data.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VoitureService {

    private final CarRepository carRepository;
    private final RefEngineTypeRepository engineTypeRepository;
    private final RefTransmissionRepository transmissionRepository;
    private final RefFuelTypeRepository fuelTypeRepository;
    private final RefCarStatusRepository carStatusRepository;

    @Autowired
    public VoitureService(CarRepository carRepository,
                          RefEngineTypeRepository engineTypeRepository,
                          RefTransmissionRepository transmissionRepository,
                          RefFuelTypeRepository fuelTypeRepository,
                          RefCarStatusRepository carStatusRepository) {
        this.carRepository = carRepository;
        this.engineTypeRepository = engineTypeRepository;
        this.transmissionRepository = transmissionRepository;
        this.fuelTypeRepository = fuelTypeRepository;
        this.carStatusRepository = carStatusRepository;
    }

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car getById(Long id) {
        return carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Voiture", id));
    }

    public List<Car> getAvailable() {
        return carRepository.findByStatus_Code("available");
    }

    public Car create(VoitureDTO dto) {
        Car car = mapToEntity(new Car(), dto);
        return carRepository.save(car);
    }

    public Car update(Long id, VoitureDTO dto) {
        Car car = getById(id);
        mapToEntity(car, dto);
        return carRepository.save(car);
    }

    public void delete(Long id) {
        Car car = getById(id);
        carRepository.delete(car);
    }

    private Car mapToEntity(Car car, VoitureDTO dto) {
        car.setMake(dto.getMarque());
        car.setModel(dto.getModele());
        car.setYear(dto.getAnnee());
        car.setLicensePlate(dto.getImmatriculation());
        car.setColor(dto.getCouleur());
        car.setMileage(dto.getKilometrage());
        car.setPricePerDay(dto.getPrixParJour());
        car.setNotes(dto.getNotes());

        if (dto.getTypeMoteurId() != null) {
            car.setEngineType(engineTypeRepository.findById(dto.getTypeMoteurId())
                    .orElseThrow(() -> new ResourceNotFoundException("TypeMoteur", dto.getTypeMoteurId())));
        }
        if (dto.getTransmissionId() != null) {
            car.setTransmission(transmissionRepository.findById(dto.getTransmissionId())
                    .orElseThrow(() -> new ResourceNotFoundException("Transmission", dto.getTransmissionId())));
        }
        if (dto.getTypeCarburantId() != null) {
            car.setFuelType(fuelTypeRepository.findById(dto.getTypeCarburantId())
                    .orElseThrow(() -> new ResourceNotFoundException("TypeCarburant", dto.getTypeCarburantId())));
        }
        if (dto.getStatutId() != null) {
            car.setStatus(carStatusRepository.findById(dto.getStatutId())
                    .orElseThrow(() -> new ResourceNotFoundException("StatutVoiture", dto.getStatutId())));
        }

        return car;
    }
}
