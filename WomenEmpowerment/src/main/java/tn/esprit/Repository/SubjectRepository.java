package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Subject;


@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
	
	// public boolean existsByTitleSub(String TitleSub);
	
	Subject findBytitleSub(String titleSub);

}
