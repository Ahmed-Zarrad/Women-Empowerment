package tn.esprit.Repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.Entity.AppUser;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.Gender;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface IUserRepository extends CrudRepository<AppUser, Integer>{
	

	
	AppUser findByUsername(String username);
	
	List<AppUser> findByStateUser(boolean stateUser);
	
	List<AppUser> findByAdressUser(String adressUser);
	
	List<AppUser> findByBirthDateUser(Date birthDateUser);
	
	List<AppUser> findByGender(Gender gender);

	AppUser findByEmail(String email);
	//AppUser findByEmail(String email);

	
	long  count();
	
    public AppUser findByResettoken(String token);
	
	AppUser findUserByresettoken(String login);
	


	AppUser findByPassword(String password);

	AppUser findByConfirmPasswordUser(String confirmPasswordUser);
	
	//List<AppUser> findByRole(Role role);
	boolean existsByEmail(String email);
	Optional<AppUser> findByRole(Role role);





	
	@Query("SELECT u.role FROM AppUser u where  u.idUser =:id")
	public String getUserRole(@Param("id")int id);
	
	@Query("SELECT CONCAT(u.username,CONCAT(' ',u.lastNameUser)) FROM AppUser u where  u.stateUser =TRUE")
	public List<String> getUsersFromActivated();
	
	@Query("SELECT CONCAT(u.username,CONCAT(' ',u.lastNameUser)) FROM AppUser u where  u.stateUser =FALSE")
	public List<String> getUsersFromDisabled();
	
	@Query("Select u FROM AppUser u where u.role= :role")
	List<AppUser> findAllByRole(@Param("role") AppUser appUser);

	@Query("SELECT e.username,e.email FROM AppUser e")
	List<String> getAllMemberNames();
	
	@Query("SELECT e.phoneNumberUser,e.adressUser FROM AppUser e GROUP BY e.adressUser")
	List<String> getphonegroupbyadress();
	
	@Query("SELECT MAX(e.birthDateUser) FROM AppUser e ")
	Date getminage();


}
