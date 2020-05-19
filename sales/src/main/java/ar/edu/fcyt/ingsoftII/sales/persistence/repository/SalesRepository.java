package ar.edu.fcyt.ingsoftII.sales.persistence.repository;

import ar.edu.fcyt.ingsoftII.sales.persistence.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesRepository extends JpaRepository<Sale, Long> {
}
