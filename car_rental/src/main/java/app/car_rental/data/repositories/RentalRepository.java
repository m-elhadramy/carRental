package app.car_rental.data.repositories;

import app.car_rental.data.entities.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findByClient_Id(Long clientId);

    List<Rental> findByEndDateGreaterThanEqual(LocalDate date);
}
