package tn.esprit.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.Entity.Claim;
@Repository
public interface ClaimRepository extends CrudRepository<Claim, Integer>{
	
	@Query(value=" SELECT  categoryclaim_id FROM (SELECT category_key.categoryclaim_id,COUNT(*) as count_keys FROM category_key WHERE category_key.text_key IN ?1 GROUP BY category_key.categoryclaim_id)p ORDER BY  p.count_keys DESC LIMIT 1 ", nativeQuery = true)
    int GET_CategooryAuto( List<String> name);
	

}
 