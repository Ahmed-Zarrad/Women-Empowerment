package tn.esprit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.JobOffre;

import java.util.List;

@Repository
public interface JobOffreRepository extends JpaRepository<JobOffre,Integer> {
    List<JobOffre> findBySalaryEquals(Float Salary);

    List<JobOffre> findBySalaryIsGreaterThanEqual(Float salary);

    List<JobOffre> findBySalaryLessThan(Float salary);
}
