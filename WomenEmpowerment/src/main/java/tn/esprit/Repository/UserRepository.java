package tn.esprit.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.Userx;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<Userx ,Long>  {


	@Query("FROM Userx u WHERE u.idUser = :idUser")
	List<Userx> findUserByID(@Param(value = "idUser") Long idUser);

	@Query("FROM Userx u WHERE u.email = :email")
	Userx findUserByemail(@Param(value = "email") String email);


	@Query("FROM Userx u WHERE u.role = :role")
	 List<Userx> findUserByRole(@Param(value = "role") Role role);
	
}

