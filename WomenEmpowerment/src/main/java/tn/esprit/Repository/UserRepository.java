package tn.esprit.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.AppUser;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<AppUser,Long>  {


	@Query("FROM AppUser u WHERE u.idUser = :idUser")
	List<AppUser> findUserByID(@Param(value = "idUser") Long idUser);

	@Query("FROM AppUser u WHERE u.email = :email")
    AppUser findUserByemail(@Param(value = "email") String email);


	@Query("FROM AppUser u WHERE u.role = :role")
	 List<AppUser> findUserByRole(@Param(value = "role") Role role);

	AppUser findByEmail(String email);
	
}

