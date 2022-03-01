package tn.esprit.services;

import java.util.List;

import tn.esprit.Entity.Participant;



public interface IParticipantService {
	
	public int ajouterParticipant(Participant participant);
	
	
	List<Participant> getAllParticipant();
	public void deleteParticipantById(int participantId);

	
}
