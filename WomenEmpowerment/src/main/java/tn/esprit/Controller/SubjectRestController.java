package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Subject;
import tn.esprit.Service.ISubjectService;

@RestController
public class SubjectRestController {
	
	@Autowired
	ISubjectService subrepo;
	
	
	// http://localhost:8085/addSubject/{idUserx}
	
	@PostMapping("/addSubject/{Id}")
	public Subject addSubject(@RequestBody Subject subjects, @PathVariable("Id") int Id){
		subrepo.addSubject(subjects, Id);
		return subjects;
	}
	
	
	
	// http://localhost:8085/deleteSubject/{subject-id}
	
	@DeleteMapping("/deleteSubject/{subject-id}")
	public boolean deleteSubject(@PathVariable("subject-id") int IdSub) {
		return	subrepo.deleteSubject(IdSub);
		
		}

	// http://localhost:8085/update-subject
	
	@PutMapping("/update-subject")
	public Subject updateSubject(@RequestBody Subject sub) {
		return subrepo.updateSubject(sub);
		}
	
	
	// http://localhost:8085/retrieve-all-subjects
	
	@GetMapping("/retrieve-all-subjects")
	public List<Subject> retrieveAllSubject(){
		List<Subject> list =subrepo.retrieveAllSubject();
		return list;
	}
	
	
	// http://localhost:8085/retrieve-subject-by-title/{subject-title}
	
	@GetMapping("/retrieve-subject-by-title/{subject-title}")
	public List<Subject> retrievesubject(@PathVariable("subject-title") String titleSub) {
		return subrepo.retrievesubject(titleSub);
		}
}
