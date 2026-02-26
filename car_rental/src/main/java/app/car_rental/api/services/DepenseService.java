package app.car_rental.api.services;

import app.car_rental.api.dto.DepenseDTO;
import app.car_rental.api.exceptions.ResourceNotFoundException;
import app.car_rental.data.entities.Depense;
import app.car_rental.data.repositories.CarRepository;
import app.car_rental.data.repositories.DepenseRepository;
import app.car_rental.data.repositories.RefDepenseTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class DepenseService {

    private final DepenseRepository depenseRepository;
    private final CarRepository carRepository;
    private final RefDepenseTypeRepository depenseTypeRepository;

    @Autowired
    public DepenseService(DepenseRepository depenseRepository, CarRepository carRepository, RefDepenseTypeRepository depenseTypeRepository) {
        this.depenseRepository = depenseRepository;
        this.carRepository = carRepository;
        this.depenseTypeRepository = depenseTypeRepository;
    }

    public List<Depense> getAll() {
        return depenseRepository.findAll();
    }

    public Depense getById(Long id) {
        return depenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Depense", id));
    }

    public List<Depense> getByCar(Long voitureId) {
        return depenseRepository.findByVoiture_Id(voitureId);
    }

    public List<Depense> getByType(Long typeId) {
        return depenseRepository.findByType_Id(typeId);
    }

    public BigDecimal getTotalByPeriod(LocalDate debut, LocalDate fin) {
        return depenseRepository.sumMontantByDateBetween(debut, fin);
    }

    public Depense create(DepenseDTO dto) {
        Depense depense = mapToEntity(new Depense(), dto);
        return depenseRepository.save(depense);
    }

    public Depense update(Long id, DepenseDTO dto) {
        Depense depense = getById(id);
        mapToEntity(depense, dto);
        return depenseRepository.save(depense);
    }

    public void delete(Long id) {
        Depense depense = getById(id);
        depenseRepository.delete(depense);
    }

    private Depense mapToEntity(Depense depense, DepenseDTO dto) {
        depense.setVoiture(carRepository.findById(dto.getVoitureId())
                .orElseThrow(() -> new ResourceNotFoundException("Voiture", dto.getVoitureId())));
        depense.setType(depenseTypeRepository.findById(dto.getTypeId())
                .orElseThrow(() -> new ResourceNotFoundException("TypeDepense", dto.getTypeId())));
        depense.setMontant(dto.getMontant());
        depense.setDate(dto.getDate());
        depense.setDescription(dto.getDescription());
        return depense;
    }
}
