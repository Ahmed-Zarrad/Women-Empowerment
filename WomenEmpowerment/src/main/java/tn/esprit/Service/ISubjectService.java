package tn.esprit.Service;

import java.util.List;

import tn.esprit.Entity.Subject;


public interface ISubjectService {
	
	 public void addSubject(Subject subjects, int iduserx);
	 
	 
	 boolean deleteSubject(int IdSub);
	 
	 Subject updateSubject(Subject s);
	 
	 
	 List<Subject> retrieveAllSubject();
	 
	 
      Subject  retrievesubject(String titleSub);
      
      public String aaaddSubject(Subject s);
	 
	 
	 
	 
}
