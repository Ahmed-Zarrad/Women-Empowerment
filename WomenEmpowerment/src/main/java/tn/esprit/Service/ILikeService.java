package tn.esprit.Service;


import java.util.List;

import tn.esprit.Entity.Liking;

public interface ILikeService {
	
	
	
	public boolean isLikeExists(int idUser, int idSubject);
	
	
	public Boolean addLiking(Liking li, int idUser, int idSubject);
	
	
	public void deleteLiking(int id);
	
	
	public int getNombreLike(int idSubject);
	
	
	
	
	
	
	
	

}
