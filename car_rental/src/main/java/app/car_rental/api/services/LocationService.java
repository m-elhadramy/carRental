package app.car_rental.api.services;

import app.car_rental.api.dto.LocationDTO;
import app.car_rental.api.exceptions.ResourceNotFoundException;
import app.car_rental.data.entities.Rental;
import app.car_rental.data.repositories.CarRepository;
import app.car_rental.data.repositories.ClientRepository;
import app.car_rental.data.repositories.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LocationService {

    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final ClientRepository clientRepository;

    @Autowired
    public LocationService(RentalRepository rentalRepository,
                           CarRepository carRepository,
                           ClientRepository clientRepository) {
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
        this.clientRepository = clientRepository;
    }

    public List<Rental> getAll() {
        return rentalRepository.findAll();
    }

    public Rental getById(Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Location", id));
    }

    public List<Rental> getActive() {
        return rentalRepository.findByEndDateGreaterThanEqual(LocalDate.now());
    }

    public List<Rental> getByClient(Long clientId) {
        return rentalRepository.findByClient_Id(clientId);
    }

    public Rental create(LocationDTO dto) {
        Rental rental = mapToEntity(new Rental(), dto);
        return rentalRepository.save(rental);
    }

    public Rental update(Long id, LocationDTO dto) {
        Rental rental = getById(id);
        mapToEntity(rental, dto);
        return rentalRepository.save(rental);
    }

    public Rental endRental(Long id) {
        Rental rental = getById(id);
        rental.setEndDate(LocalDate.now());
        return rentalRepository.save(rental);
    }

    public void delete(Long id) {
        Rental rental = getById(id);
        rentalRepository.delete(rental);
    }

    private Rental mapToEntity(Rental rental, LocationDTO dto) {
        rental.setCar(carRepository.findById(dto.getVoitureId())
                .orElseThrow(() -> new ResourceNotFoundException("Voiture", dto.getVoitureId())));
        rental.setClient(clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client", dto.getClientId())));
        rental.setStartDate(dto.getDateDebut());
        rental.setEndDate(dto.getDateFin());
        rental.setTotalPrice(dto.getPrix());
        rental.setGps(dto.isGps());
        rental.setChildSeat(dto.isChildSeat());
        rental.setInsurance(dto.isInsurance());
        return rental;
    }
}
