package tn.esprit.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.Entity.Cagnotte;



public interface ICagnotteService {
	
	Cagnotte addCagnotte(Cagnotte c);

	List<Cagnotte> getAllCagnotte();

	void deleteCagnotte(int idCagnotte);

	Cagnotte updateCagnotte(Cagnotte c);

	Optional<Cagnotte> getCagnotte_by_ID(int idCagnotte);

}
