package tn.esprit.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.CategoryClaim;
@Repository
public interface CategoryClaimRepository extends CrudRepository<CategoryClaim, Integer> {

}
