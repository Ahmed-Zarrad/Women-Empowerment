package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.CategoryClaim;
import tn.esprit.Repository.CategoryClaimRepository;

import java.util.List;
@Service
public class CategoryClaimServiceImpl implements CategoryClaimService{

	@Autowired
	CategoryClaimRepository categoryclaimRepository;
	
	@Override
	public CategoryClaim addCategoryClaim(CategoryClaim cc) {
		return categoryclaimRepository.save(cc);
	}

	@Override
	public void deleteCategoryClaim(int id) {
		categoryclaimRepository.deleteById(id);
		
	}

	@Override
	public CategoryClaim updateCategoryClaim(CategoryClaim cc) {
		return categoryclaimRepository.save(cc);

	}

	@Override
	public CategoryClaim retrieveCategoryClaim(int id) {
		return categoryclaimRepository.findById(id).orElse(null);
	}
	@Override
	public List<CategoryClaim> retrieveAllCategoryClaims() {
		return (List<CategoryClaim>) categoryclaimRepository.findAll();
	}

}
