package app.car_rental.data.repositories;

import app.car_rental.data.entities.RefDepenseType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefDepenseTypeRepository extends JpaRepository<RefDepenseType, Long> {
}
