package tn.esprit.Service;


import tn.esprit.Entity.Comment;

import java.util.List;


public interface ICommentService {
	
	
	int addCommentaire(Comment c, int idS , int idU);
	
	// Comment affectercommentavecSubjectetUser(int idc, int idS, int idU);
	 
	 boolean deleteComment(int idCom);
	 
	 Comment updateComment(Comment c);
	 
	
	 
	 
	 List<Comment> getAllCommentBySubject(String titlesub);
	 
	
	
	 public int getNombreComment(String title);
	 
	 
	// public void deleteAllComment(String title);
	 
	 
	 

}
