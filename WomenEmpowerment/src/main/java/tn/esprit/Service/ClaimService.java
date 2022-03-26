package tn.esprit.Service;

import java.util.List;

import tn.esprit.Entity.Claim;

public interface ClaimService {
	
	public Claim addClaim(Claim c);
	
	void deleteClaim(int id);
	
	Claim updateClaim(Claim c);

	Claim retrieveClaim(int id);

	List<Claim> retrieveAllClaims();

	Claim addClaimWithCategory(Claim c);
}

