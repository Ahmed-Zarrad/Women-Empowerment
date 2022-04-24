package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Subject;
import tn.esprit.Service.ISubjectService;

import java.sql.Date;
import java.util.List;






@RestController
public class SubjectRestController {
	
	@Autowired
	ISubjectService subrepo;
	
	
	// http://localhost:8085/addSubject/{idUser}
	
	@PostMapping("/addSubject/{Id}")
	public Subject addSubject(@RequestBody Subject subjects, @PathVariable("Id") int Id){
		subrepo.addSubject(subjects, Id);
		return subjects;
	}
	
	/*
	@PostMapping("/addSubject")
	public String aaaddSubject(@RequestBody Subject s){
		return subrepo.aaaddSubject(s);
	}
	*/
	
	// http://localhost:8085/aaaddSubject/{idUser}
	
	@PostMapping("/aaaddSubject/{Id}")
	public String aaaddSubject(@RequestBody Subject s, @PathVariable int Id){
		return subrepo.aaaddSubject(s, Id);
		
	}
	
	
	// http://localhost:8085/deleteSubject/{subject-id}
	
	@DeleteMapping("/deleteSubject/{subject-id}")
	public boolean deleteSubject(@PathVariable("subject-id") int IdSub) {
		return	subrepo.deleteSubject(IdSub);
		
		}

	// http://localhost:8085/update-subject{id}
	
	@PutMapping("/update-subject/{id}")
	public String updateSubject(@RequestBody Subject sub ,@PathVariable int id ) {
			
		return subrepo.updateSubject(sub, id);
		}
	
	
	// http://localhost:8085/retrieve-all-subjects
	
	@GetMapping("/retrieve-all-subjects")
	public List<Subject> retrieveAllSubject(){
		List<Subject> list =subrepo.retrieveAllSubject();
		return list;
	}
	
	
	// http://localhost:8085/retrieve-subject-by-title/{subject-title}
	
	@GetMapping("/retrieve-subject-by-title/{subject-title}")
	public Subject retrievesubject(@PathVariable("subject-title") String titleSub) {
		return subrepo.retrievesubject(titleSub);
		}
	

	
	// http://localhost:8085/listeSubjectByUser/{iduser}
	
	@GetMapping("/listeSubjectByUser/{iduser}")
	public List<Subject> listeSubjectByUser(@PathVariable ("iduser")int Id){
		return subrepo.listeSubjectByUser(Id);
	}
	
	// http://localhost:8085/getAllSubjectbyId/{iduser}
	
		@GetMapping("/getAllSubjectbyId/{Iduser}")
		
		public List<Subject> getAllSubjectbyId(@PathVariable ("Iduser")int Iduser){
			return subrepo.getAllSubjectbyId(Iduser);
		}
		
		
		// http://localhost:8085/getAllSubjectByName/{name}
		
			@GetMapping("/getAllSubjectByName/{name}")
			
			public List<Subject> getAllSubjectByName(@PathVariable ("name")String name){
				return subrepo.getAllSubjectByName(name);
			}
			
			
			// http://localhost:8085/retrieveallSubjectByDate/d1/d2
			
			
			@GetMapping("/retrieveallSubjectByDate/{d1}/{d2}")
			public List<Subject> retrieveallSubjectByDate(@PathVariable  Date d1,@PathVariable  Date d2){
				return subrepo.retrieveallSubjectByDate(d1, d2);
				  
				
			}
			
			// http://localhost:8085/getAllsubjecttitle
			
			@GetMapping("/getAllsubjecttitle")
			public List<String> getAllsubjecttitle(){
				return subrepo.getAllsubjecttitle();
			}
			
			
			// http://localhost:8085/retrieveSubjectByStarsGreaterThan/{subject-stars}
			
			@GetMapping("/retrieveSubjectByStarsGreaterThan/{subject-stars}")
			public List<Subject> retrieveSubjectByStarsGreaterThan(@PathVariable ("subject-stars") int starsNumberSubject) {
			return subrepo.retrieveSubjectByStarsGreaterThan(starsNumberSubject);
			}
			
			
			
			// http://localhost:8085/findByStarsNumberSubjectLessThan/{subject-stars}
			
			@GetMapping("/findByStarsNumberSubjectLessThan/{subjectstars}")
			public List<Subject> findByStarsNumberSubjectLessThan(@PathVariable("subjectstars" )int starsNumberSubject){
			return subrepo.findByStarsNumberSubjectLessThan(starsNumberSubject);
			}
			
		
			// http://localhost:8085/retrievesuborderbystars
			
			@GetMapping("/retrievesuborderbystars")
			public List<Subject> retrievesuborderbystars() {
			return subrepo.retrievesuborderbystars();
			}
	
			// http://localhost:8085/getmaxstarsNumberSubject
			
			
			@GetMapping("/getmaxstarsNumberSubject")
			public int getmaxstarsNumberSubject(){
				return subrepo.getmaxstarsNumberSubject();
			}
			
			
			// http://localhost:8085/afficherSubjectspluscomment
			
			@GetMapping("/afficherSubjectspluscomment")
			public List<Subject> afficherSubjectspluscomment(){
				return subrepo.afficherSubjectspluscomment();
			}
			
			
			
}
