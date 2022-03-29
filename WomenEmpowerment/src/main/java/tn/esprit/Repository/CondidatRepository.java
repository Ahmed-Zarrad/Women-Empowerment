package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Condidat;

import java.util.List;

@Repository
public interface CondidatRepository extends JpaRepository<Condidat, Long> {
    List<Condidat> findByStatusEquals(String status);


}
