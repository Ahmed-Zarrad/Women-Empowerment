package tn.esprit.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import tn.esprit.Entity.Participant;

import tn.esprit.repository.ParticipantRepository;





@Service
public class ParticipantServiceImpl implements IParticipantService {

	
	@Autowired
	ParticipantRepository participantRepoistory;
	@Transactional
	public int ajouterParticipant(Participant participant) {
		participantRepoistory.save(participant);
		return participant.getId();
	}

	
	

	
	

	@Transactional
	public void deleteParticipantById(int participantId) {
		participantRepoistory.delete(participantRepoistory.findById(participantId).get());	
	}


	



	@Override
	public List<Participant> getAllParticipant() {
		return (List<Participant>) participantRepoistory.findAll();
	}

}
