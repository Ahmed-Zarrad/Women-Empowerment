package tn.esprit.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Entity.AppUser;

public interface UserRepository extends JpaRepository <AppUser, Integer>{
 
	
	
}
