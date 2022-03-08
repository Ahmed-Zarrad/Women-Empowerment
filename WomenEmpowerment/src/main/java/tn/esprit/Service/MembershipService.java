package tn.esprit.Service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.AppUser;
import tn.esprit.Entity.Membership;
import tn.esprit.Repository.MembershipRepository;
import tn.esprit.Repository.UserRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class MembershipService implements IMembershipService {

	private MembershipRepository membershipRepository;
	private UserRepository userRepository;
	@Override
public List<Membership> getMemberships() {
	
	return membershipRepository.findAll();
}
	@Override
	public Collection<Membership> findAll() {
		return membershipRepository.findAll();
	}
	@Override
	public Membership getMembershipById(Long idMem){

	return membershipRepository.findById(idMem).orElse(null);
	}
	@Override
	public Optional<Membership> findById(Long id) {
		return membershipRepository.findById(id);
	}

/*	public List<Membership>  listedeMemberships(Long idUser) {

		return membershipRepository.findMembershipByappUser_Id(idUser);
	}*/
@Override
public Membership addMembership (Membership membership){

	return membershipRepository.saveAndFlush(membership);

}
	@Override
	public Membership saveOrUpdate(Membership membership) {
		return membershipRepository.saveAndFlush(membership);
	}
	@Override
	public Membership updateMembership (Membership membership){

		return membershipRepository.save(membership);

	}
	@Override
	public void  deleteMembership (Long idMem){
		Membership membership = membershipRepository.findById(idMem).orElse(null);
		membershipRepository.delete(membership);

	}
	@Override
	public Membership addMembership2(Membership membership, Long idUser) {

		Optional<AppUser>c=userRepository.findById(idUser);
		AppUser u2=c.get();
		membership.setAppUser(u2);
		return membershipRepository.save(membership);
	}

	/*public void ajouterETaffectermembership(Long idUser, long idMem){

		AppUser user = membershipRepository.findById(idMem).orElse(null);

		AppUser user = userRepository.findById(idUser).orElse(null);

		se
		}


	}*/

}
