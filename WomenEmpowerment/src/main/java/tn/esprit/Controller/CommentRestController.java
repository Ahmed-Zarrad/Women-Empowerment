package tn.esprit.Controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Comment;

import tn.esprit.Service.ICommentService;
import tn.esprit.Service.ISubjectService;


@RestController
public class CommentRestController {
	
	@Autowired
	ICommentService comserv;
	
	@Autowired
	ISubjectService subrepo;
	
	
	
	
	// http://localhost:8085/add-comment
	
	@PostMapping("/add-comment/{Idsub}")
	public ResponseEntity<?>ajouterCommentaire(@Validated @RequestBody Comment c){
		comserv.ajouterCommentaire(c);
		return 	ResponseEntity.ok().body(c);
	
	}
	
	
	
	// http://localhost:8085/deleteComment/{idCom}
	
		@DeleteMapping("/deleteComment/{idCom}")
		public boolean deleteComment(@PathVariable("idCom") int idCom) {
			return	comserv.deleteComment(idCom);
			
			}
	
		
		
		
		
		// http://localhost:8085/getAllCommentBySubject/{titlesub}
		
		@GetMapping("/getAllCommentBySubject/{titlesub}")
		public List<Comment> getAllCommentBySubject(@PathVariable ("titlesub")String titlesub){
			return comserv.getAllCommentBySubject(titlesub);
		}
		
		
		// http://localhost:8085/getNombreComment/{title}
		
		@GetMapping("/getNombreComment/{title}")
		public int getNombreComment(@PathVariable String title){
			
			return comserv.getNombreComment(title);
		}
		
		
	/*	
		
		// http://localhost:8085/deleteAllCoomment/{title}
		
		 @DeleteMapping("/deleteAllCoomment/{title}") 
			
			public void deleteAllCoomment(String title) {
				comserv.deleteAllComment(title);
				
			}
		*/
}
