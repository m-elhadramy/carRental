package app.car_rental.data.repositories;

import app.car_rental.data.entities.SysMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu, Long> {

    List<SysMenu> findByParentIsNullOrderByOrdreAsc();
}
