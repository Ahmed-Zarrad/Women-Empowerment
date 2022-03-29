package tn.esprit.Service;

import java.sql.Date;
import java.util.List;



import tn.esprit.Entity.Subject;



public interface ISubjectService {
	
	 public void addSubject(Subject subjects, int Id);
	 
	 public String aaaddSubject(Subject s, int Id);
	 
	 
	 boolean deleteSubject(int IdSub);
	 
	 String updateSubject(Subject s , int id);
	 
	 
	 List<Subject> retrieveAllSubject();
	 
	 
      Subject  retrievesubject(String titleSub);
      
      
      List<Subject> listeSubjectByUserx(int Id);
      
     
      List<Subject> getAllSubjectbyId(int Iduser);
      
      public List<Subject> getAllSubjectByName(String name);
      
      
      public List<Subject> retrieveallSubjectByDate (Date d1,Date d2);
    
      
      
     
      public List<String> getAllsubjecttitle();
      
      
      List<Subject> retrieveSubjectByStarsGreaterThan(int starsNumberSubject);
      
      List<Subject> findByStarsNumberSubjectLessThan(int starsNumberSubject);

	  
      
      List<Subject> retrievesuborderbystars();
	 
      
      
      public int getmaxstarsNumberSubject();
      
      
      
      List<Subject> afficherSubjectspluscomment();
      
      
      
	 
	 
	 
}
