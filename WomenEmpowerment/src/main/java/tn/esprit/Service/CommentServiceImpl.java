package tn.esprit.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.Comment;
import tn.esprit.Entity.Subject;
import tn.esprit.Entity.Userx;
import tn.esprit.Repository.CommentRepository;
import tn.esprit.Repository.SubjectRepository;
import tn.esprit.Repository.UserxRepository;

@Service
public class CommentServiceImpl implements ICommentService {
	
	
	@Autowired
	CommentRepository comrepo;
	
	@Autowired
	SubjectRepository subrepo;
	
	@Autowired
	UserxRepository userxrepo;
	
	
	
	

	

	



	@Override
	public boolean deleteComment(int idCom) {
		if (comrepo.existsById(idCom)){
			comrepo.deleteById(idCom);
			return true;
		}else
		return false;
	}





	@Override
	public Comment updateComment(Comment c) {
		return comrepo.save(c);

	}





	@Override
	public List<Comment> getAllCommentBySubject(String titlesub) {
		Subject subjectt = subrepo.findBytitleSub(titlesub);
		return comrepo.findBySubject(subjectt);
	
	}





	@Override
	public int getNombreComment(String title) {
		
		 return comrepo.countcomment(title);
		
	}





	@Override
	public int addCommentaire(Comment c, int idS , int idU) {
		
         Subject subjectt = subrepo.findById(idS).orElse(null);
		
         Userx userx = userxrepo.findById(idU).orElse(null);
         
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
	 c.setSubject(subjectt);
	 c.setUserx(userx);
	 comrepo.save(c);
	return c.getIdCom();
	}





	


	


	










/*
	@Override
	public void deleteAllComment(String title) {
		comrepo.deleteAllComment(title);
		
	}

*/



	







	

}
