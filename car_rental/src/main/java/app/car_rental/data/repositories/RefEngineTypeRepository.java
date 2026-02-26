package app.car_rental.data.repositories;

import app.car_rental.data.entities.RefEngineType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefEngineTypeRepository extends JpaRepository<RefEngineType, Long> {
}
