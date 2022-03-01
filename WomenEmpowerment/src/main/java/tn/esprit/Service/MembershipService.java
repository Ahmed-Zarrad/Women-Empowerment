package tn.esprit.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Userx;
import tn.esprit.Entity.Membership;
import tn.esprit.Repository.MembershipRepository;
import tn.esprit.Repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class MembershipService {

	private MembershipRepository membershipRepository;
	private UserRepository userRepository;

public List<Membership> getMemberships() {
	
	return membershipRepository.findAll();
}
public Membership getMembershipById(Long idMem){

	return membershipRepository.findById(idMem).orElse(null);
	}

/*	public List<Membership>  listedeMemberships(Long idUser) {

		return membershipRepository.findMembershipByUserx_Id(idUser);
	}*/

public Membership addMembership (Membership membership){

	return membershipRepository.save(membership);

}
	public Membership updateMembership (Membership membership){

		return membershipRepository.save(membership);

	}
	public void  deleteMembership (Long idMem){
		Membership membership = membershipRepository.findById(idMem).orElse(null);
		membershipRepository.delete(membership);

	}
	/*public void ajouterETaffectermembership(Long idUser, long idMem){

		Userx user = membershipRepository.findById(idMem).orElse(null);

		Userx user = userRepository.findById(idUser).orElse(null);

		se
		}


	}*/

}
