package tn.esprit.services;

import java.util.List;

import tn.esprit.Entity.CharityEvent;

public interface ICharityEventService {
	
	public int ajouterCharityEvent(CharityEvent event) ;
	
	public void deleteCharityEventById(int eventId); 
	
	List<CharityEvent>retreiveAllEvent();
	

	public void updateLocationByEventId(String location, int eventId);
}
 