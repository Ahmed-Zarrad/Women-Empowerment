package tn.esprit.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.Subject;
import tn.esprit.Entity.Userx;
import tn.esprit.Repository.SubjectRepository;
import tn.esprit.Repository.UserxRepository;


@Service
public class SubjectServiceImpl implements ISubjectService {
	
	
	@Autowired
	SubjectRepository subrepo;
	
	@Autowired
	UserxRepository userxrepo;

	


	

	

	@Override
	public void addSubject(Subject subjects, int Id) {
		Userx userx = userxrepo.findById(Id).orElse(null);
		subjects.setUserx(userx);
        subrepo.save(subjects);
		
	}

	@Override
	public boolean deleteSubject(int IdSub) {
		if (subrepo.existsById(IdSub)){
			subrepo.deleteById(IdSub);
			return true;
		}else
		return false;
	}
	
	
	
	@Override
	public Subject updateSubject(Subject s) {
		
		return subrepo.save(s);
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
	 public String aaaddSubject(Subject s) {
		if (subrepo.findBytitleSub(s.getTitleSub()) != null){
			return "This Subject Exist";
		}else
			return (String) subrepo.save(s).toString().concat("\n Subject Added Succefully");
	   }
	 }
   
	
	
	

