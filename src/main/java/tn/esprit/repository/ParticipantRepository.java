package tn.esprit.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Participant;

@Repository
public interface ParticipantRepository extends CrudRepository<Participant, Integer>  {


	
	
}
