package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.Entity.Liking;
import tn.esprit.Service.ILikeService;

@RestController
public class LikeRestController {
	
	@Autowired
	ILikeService likeserv;
	
	// http://localhost:8085/add-like/{id-user}/{id-post}
	
	@PostMapping("/add-like/{id-user}/{id-post}")
	public ResponseEntity<String> ajouterEtaffecterListePosts(@RequestBody Liking likee,@PathVariable(value = "id-user") int id, @PathVariable(value="id-post")int idsub) 
	{
		if(likeserv.addLiking(likee, id,idsub)) {
			return new ResponseEntity<String>("Nice your like is added :)",HttpStatus.OK);

		}
		else {
			return new ResponseEntity<String>("Sorry you already like this post  :)",HttpStatus.OK);

		}

	}
	
	
	// http://localhost:8085/delete-like/{id-like}
	
	@DeleteMapping("/delete-like/{id-like}")
	@ResponseBody
	public ResponseEntity<String> deleteLiking(@PathVariable("id-like") int id){
		likeserv.deleteLiking(id);
		return new ResponseEntity<String>("Like deleted with success   :)",HttpStatus.OK);
	}
	
	
	
	// http://localhost:8085/getNombreLike/{idSubject}
	
			@GetMapping("/getNombreLike/{idSubject}")
	public int getNombreLike(@PathVariable int idSubject){
		
	
		return likeserv.getNombreLike(idSubject);
	}
	
	
	
	
			
	
	
	
	
	
	
	
		
	}
	


