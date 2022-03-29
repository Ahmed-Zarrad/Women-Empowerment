package tn.esprit.Service;

import tn.esprit.Entity.Claim;

import java.util.List;

public interface ClaimService {
	
	public Claim addClaim(Claim c);
	
	void deleteClaim(int id);
	
	Claim updateClaim(Claim c);

	Claim retrieveClaim(int id);

	List<Claim> retrieveAllClaims();

	Claim addClaimWithCategory(Claim c);
}

