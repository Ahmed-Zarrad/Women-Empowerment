package tn.esprit.Service;

import java.util.List;

import tn.esprit.Entity.CategoryClaim;

public interface CategoryClaimService {
	CategoryClaim addCategoryClaim(CategoryClaim cc);
	
	void deleteCategoryClaim(int id);
	
	CategoryClaim updateCategoryClaim(CategoryClaim cc);

	CategoryClaim retrieveCategoryClaim(int id);

	List<CategoryClaim> retrieveAllCategoryClaims();
}
