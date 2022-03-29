package tn.esprit.Service;

import tn.esprit.Entity.CategoryClaim;

import java.util.List;

public interface CategoryClaimService {
	CategoryClaim addCategoryClaim(CategoryClaim cc);
	
	void deleteCategoryClaim(int id);
	
	CategoryClaim updateCategoryClaim(CategoryClaim cc);

	CategoryClaim retrieveCategoryClaim(int id);

	List<CategoryClaim> retrieveAllCategoryClaims();
}
