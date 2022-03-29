package tn.esprit.Service;

import java.sql.Date;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.Entity.Subject;
import tn.esprit.Entity.Userx;
import tn.esprit.Repository.CommentRepository;
import tn.esprit.Repository.SubjectRepository;
import tn.esprit.Repository.UserxRepository;


@Service
public class SubjectServiceImpl implements ISubjectService {
	
	
	@Autowired
	SubjectRepository subrepo;
	
	@Autowired
	UserxRepository userxrepo;
	
	@Autowired
	CommentRepository comrepo;


	@Override
	public void addSubject(Subject subjects, int Id) {
		Userx userx = userxrepo.findById(Id).orElse(null);
		subjects.setUserx(userx);
        subrepo.save(subjects);
		
	}
	 
	
	@Override
	public String aaaddSubject(Subject s, int Id) {
		Userx xxx = userxrepo.findById(Id).orElse(null);
		   s.setUserx(xxx);
		if (subrepo.findBytitleSub(s.getTitleSub()) != null){
			
			return "This Subject Exist";
		}else
			return (String) subrepo.save(s).toString().concat("\n Subject Added Succefully");
	}
	
	/*
	@Override
	 public String aaaddSubject(Subject s) {
		if (subrepo.findBytitleSub(s.getTitleSub()) != null){
			return "This Subject Exist";
		}else
			return (String) subrepo.save(s).toString().concat("\n Subject Added Succefully");
	   }
	
	*/

	@Override
	public boolean deleteSubject(int IdSub) {
		if (subrepo.existsById(IdSub)){
			subrepo.deleteById(IdSub);
			return true;
		}else
		return false;
	}
	

	@Override
	public String updateSubject(Subject s, int id) {
		Userx xxx = userxrepo.findById(id).orElse(null);
		   s.setUserx(xxx);
		if (subrepo.findBytitleSub(s.getTitleSub()) != null){
			
			return "This Subject Exist";
		}else
			return (String) subrepo.save(s).toString().concat("\n Subject Added Succefully");
	}
	
	
	
	@Override
	public List<Subject> retrieveAllSubject() {
		
		return (List<Subject>) subrepo.findAll();
	}

	
	
	@Override
	public Subject retrievesubject(String titleSub) {
		return  subrepo.findBytitleSub(titleSub);
	}


	@Override
	public List<Subject> listeSubjectByUserx(int Id) {
		Userx userxx = userxrepo.findById(Id).orElse(null);
		return subrepo.findByUserx(userxx);
		
	}


	@Override
	public List<Subject> getAllSubjectbyId(int Iduser) {
		return subrepo.getAllSubjectbyId(Iduser);
	}


	@Override
	public List<Subject> getAllSubjectByName(String name) {
		return subrepo.getAllSubjectByName(name);
	}


	@Override
	public List<Subject> retrieveallSubjectByDate(Date d1, Date d2) {
		List<Subject> Subjectss = subrepo.retrieveallSubjectByDate(d1, d2);
		return Subjectss;
	}


	@Override
	public List<String> getAllsubjecttitle() {
		return subrepo.subjecttitle();
		
	}


	@Override
	public List<Subject> retrieveSubjectByStarsGreaterThan(int starsNumberSubject) {
		return subrepo.findByStarsNumberSubjectGreaterThan(starsNumberSubject);
		
	}


	@Override
	public List<Subject> findByStarsNumberSubjectLessThan(int starsNumberSubject) {
		
		return subrepo.findByStarsNumberSubjectLessThan(starsNumberSubject);
		
		
	}


	@Override
	public int getmaxstarsNumberSubject() {
		return subrepo.getmaxstarsNumberSubject();
	}


	

    @Override
	public List<Subject> retrievesuborderbystars() {

		return subrepo.retrievesuborderbystars();
	}


	@Override
	public List<Subject> afficherSubjectspluscomment() {
		List<Subject> Subjectss = subrepo.findAll();
		Comparator<Subject> comp = (x, y) ->y.getComments().size()-x.getComments().size();
		return Subjectss.stream().sorted(comp).collect(Collectors.toList());
	}


	
	
	
	





	

	


	


	




	
		
	



	



	



	


	
	

	
	
	
	
}
   
	
	
	

