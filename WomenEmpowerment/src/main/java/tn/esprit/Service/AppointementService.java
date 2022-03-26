package tn.esprit.Service;

import java.util.List;

import tn.esprit.Entity.Appointement;


public interface AppointementService {
 
	Appointement addAppointement(Appointement A);
	
	void deleteAppointement(int id);
	
	Appointement updateAppointement(Appointement A);

	Appointement retrieveAppointement(int id);

	List<Appointement> retrieveAllAppointements();
	
	void affectationAppointementByUser(int idApp, int idUser);
}
