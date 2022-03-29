package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Claim;
import tn.esprit.Entity.Stat_Claim;

import java.util.List;

@Repository
public interface Stat_ClaimRepository extends JpaRepository<Claim, Integer> {
	
	@Query ("SELECT new tn.esprit.Entity.Stat_Claim(categoryclaim.lib,count(IdClaim)) from  Claim  group by categoryclaim.id order by count (IdClaim) DESC" )
    
	List<Stat_Claim> statistique();
}
