package tn.esprit.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.Entity.CategoryClaim;
import tn.esprit.Entity.Claim;
import tn.esprit.Repository.CategoryClaimRepository;
import tn.esprit.Repository.ClaimRepository;


@Service
public class ClaimServiceImpl implements ClaimService{

	@Autowired
	ClaimRepository claimrepository ;
	@Autowired
	CategoryClaimRepository categoryclaimRepository;
	@Override
	public Claim addClaim(Claim c) {
				return claimrepository.save(c);
	}
	@Override
	public Claim addClaimWithCategory(Claim c) {
		String[] splitted = c.getDescriptionClaim().split(" ");
		List<String> keys = new ArrayList<String>();
		for (String values : splitted) {
			keys.add(values);
		}
		int cat = claimrepository.GET_CategooryAuto(keys);
	    CategoryClaim categ = categoryclaimRepository.findById(cat).orElse(null);
	    c.setCategoryclaim(categ);
 		return claimrepository.save(c);
}
	@Override
	public void deleteClaim(int id) {
		claimrepository.deleteById(id);
	}

	@Override
	public Claim updateClaim(Claim c) {
		return claimrepository.save(c);
	}

	@Override
	public Claim retrieveClaim(int id) {
		return claimrepository.findById(id).orElse(null);

	}

	@Override
	public List<Claim> retrieveAllClaims() {
		return (List<Claim>) claimrepository.findAll();
	}
	
	

}
