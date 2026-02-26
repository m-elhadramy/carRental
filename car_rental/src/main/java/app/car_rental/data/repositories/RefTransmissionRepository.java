package app.car_rental.data.repositories;

import app.car_rental.data.entities.RefTransmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefTransmissionRepository extends JpaRepository<RefTransmission, Long> {
}
