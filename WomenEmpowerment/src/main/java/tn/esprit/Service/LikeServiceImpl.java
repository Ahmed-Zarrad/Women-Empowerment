package tn.esprit.Service;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.esprit.Entity.Liking;
import tn.esprit.Entity.ReactType;
import tn.esprit.Entity.Subject;
import tn.esprit.Entity.Userx;
import tn.esprit.Repository.LikeRepository;
import tn.esprit.Repository.SubjectRepository;
import tn.esprit.Repository.UserxRepository;

@Service
public class LikeServiceImpl implements ILikeService {
	
	
	@Autowired
	LikeRepository likerepo;
	
	@Autowired
	SubjectRepository subrepo;
	
	@Autowired
	UserxRepository userxrepo;

	@Override
	public boolean isLikeExists(int idUser, int idSubject) {
		int count = likerepo.isLikeExists(idUser, idSubject);
		if (count == 0){
			return false;
		               }
		else {
			return true;
		     }
	}

	@Override
	public Boolean addLiking(Liking li, int idUser, int idSubject) {
		if(isLikeExists(idUser, idSubject) == true) {
			return false;
		}
		
		else {
			Userx userx =  userxrepo.findById(idUser).get();

			Subject subject =  subrepo.findById(idSubject).get();
			
			if(ReactType.spam.equals(li.getReactType())) {
				int spamNumber = 0;
				List<Liking> spamReacts = subject.getLikingSubject().stream().filter(elem ->ReactType.spam.equals(elem.getReactType()) ).collect(Collectors.toList());
				if(spamReacts != null) {
					spamNumber = spamReacts.size();
				}
				if(spamNumber >= 2) {
					// traitement : delete post , block user
					subrepo.delete(subject);
					return false;
				}
			}
			li.setUserx(userx);
			li.setSubject(subject);
			
			likerepo.save(li);
			
			
			return true;
			}
	}

	
	@Override
	public void deleteLiking(int id) {
	 likerepo.deleteById(id);
		
	}

	@Override
	public int getNombreLike(int idSubject) {
		return likerepo.countlike(idSubject);
	}

		


	
	
	





	
		
}

