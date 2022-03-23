package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Comment;
import tn.esprit.Service.ICommentService;


@RestController
public class CommentRestController {
	
	@Autowired
	ICommentService comserv;
	
	
	
	
	// http://localhost:8085/add-comment
	
	@PostMapping("/add-comment")
	public ResponseEntity<?>ajouterCommentaire( @Validated @RequestBody Comment c){
		comserv.ajouterCommentaire(c);
		return 	ResponseEntity.ok().body(c);
	
	}

}
