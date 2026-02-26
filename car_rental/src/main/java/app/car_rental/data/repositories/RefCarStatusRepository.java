package app.car_rental.data.repositories;

import app.car_rental.data.entities.RefCarStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefCarStatusRepository extends JpaRepository<RefCarStatus, Long> {
    Optional<RefCarStatus> findByCode(String code);
}
