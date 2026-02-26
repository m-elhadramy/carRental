package app.car_rental.data.repositories;

import app.car_rental.data.entities.Depense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface DepenseRepository extends JpaRepository<Depense, Long> {

    List<Depense> findByVoiture_Id(Long voitureId);

    List<Depense> findByType_Id(Long typeId);

    @Query("SELECT COALESCE(SUM(d.montant), 0) FROM Depense d WHERE d.date BETWEEN :debut AND :fin")
    BigDecimal sumMontantByDateBetween(@Param("debut") LocalDate debut, @Param("fin") LocalDate fin);
}
