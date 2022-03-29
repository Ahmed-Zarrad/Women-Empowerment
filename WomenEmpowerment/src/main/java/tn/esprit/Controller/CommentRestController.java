package tn.esprit.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Comment;
import tn.esprit.Service.ICommentService;
import tn.esprit.Service.ISubjectService;

import java.util.List;


@RestController
public class CommentRestController {
	
	@Autowired
	ICommentService comserv;
	
	@Autowired
	ISubjectService subrepo;
	
	
	
	// http://localhost:8085/addCommentaire{idS}/{idU}
	
	@PostMapping("/addCommentaire/{idS}/{idU}")
		public ResponseEntity<?>addCommentaire( @Validated @RequestBody Comment c,@PathVariable int idS ,@PathVariable int idU){
			comserv.addCommentaire(c , idS , idU);
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
