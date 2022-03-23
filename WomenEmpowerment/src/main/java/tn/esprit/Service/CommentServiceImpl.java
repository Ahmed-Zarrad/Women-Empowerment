package tn.esprit.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.Comment;
import tn.esprit.Repository.CommentRepository;

@Service
public class CommentServiceImpl implements ICommentService {
	
	
	@Autowired
	CommentRepository comrepo;
	
	
	
	

	@Override
	public int ajouterCommentaire(Comment c) {
		
		List<String> badwords=new ArrayList<>();
		badwords.add("badbad");
		badwords.add("badwords");
		badwords.add("bads");
		
		String motcommentaire[]=c.getDescriptionCom().split(" ");
		
		String com ="";
		
		for(String mots:motcommentaire){

			
			if (badwords.contains(mots)){
			    mots="*****";
				com=com+" "+mots;	
			}
		else
			com=com+" "+mots;}
		
		c.setDescriptionCom(com);
		comrepo.save(c);
		return c.getIdCom();
		
		
	}
	

}
