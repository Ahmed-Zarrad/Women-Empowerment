package tn.esprit.Service;



import java.util.List;

import tn.esprit.Entity.Comment;


public interface ICommentService {
	
	
	 int ajouterCommentaire(Comment c);
	 
	 boolean deleteComment(int idCom);
	 
	 Comment updateComment(Comment c);
	 
	
	 
	 
	 List<Comment> getAllCommentBySubject(String titlesub);
	 
	
	
	 public int getNombreComment(String title);
	 
	 
	// public void deleteAllComment(String title);

}
