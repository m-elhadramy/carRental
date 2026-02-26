package app.car_rental.data.repositories;

import app.car_rental.data.entities.RefPaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefPaymentMethodRepository extends JpaRepository<RefPaymentMethod, Long> {
}
