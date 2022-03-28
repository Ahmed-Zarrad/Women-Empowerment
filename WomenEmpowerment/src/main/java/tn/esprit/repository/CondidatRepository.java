package tn.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Condidat;
import tn.esprit.Entity.JobOffre;

import java.util.List;

@Repository
public interface CondidatRepository extends JpaRepository<Condidat, Long> {
    List<Condidat> findByStatusEquals(String status);


}
