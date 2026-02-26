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
        car.setMake(dto.getMake());
        car.setModel(dto.getModel());
        car.setYear(dto.getYear());
        car.setLicensePlate(dto.getLicensePlate());
        car.setColor(dto.getColor());
        car.setMileage(dto.getMileage());
        car.setPricePerDay(dto.getPricePerDay());
        car.setNotes(dto.getNotes());

        if (dto.getEngineTypeId() != null) {
            car.setEngineType(engineTypeRepository.findById(dto.getEngineTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException("TypeMoteur", dto.getEngineTypeId())));
        }
        if (dto.getTransmissionId() != null) {
            car.setTransmission(transmissionRepository.findById(dto.getTransmissionId())
                    .orElseThrow(() -> new ResourceNotFoundException("Transmission", dto.getTransmissionId())));
        }
        if (dto.getFuelTypeId() != null) {
            car.setFuelType(fuelTypeRepository.findById(dto.getFuelTypeId())
                    .orElseThrow(() -> new ResourceNotFoundException("TypeCarburant", dto.getFuelTypeId())));
        }
        if (dto.getStatusId() != null) {
            car.setStatus(carStatusRepository.findById(dto.getStatusId())
                    .orElseThrow(() -> new ResourceNotFoundException("StatutVoiture", dto.getStatusId())));
        }

        return car;
    }
}
