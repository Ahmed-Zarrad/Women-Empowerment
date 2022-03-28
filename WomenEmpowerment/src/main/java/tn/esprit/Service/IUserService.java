package tn.esprit.Service;

import org.springframework.http.ResponseEntity;
import tn.esprit.Entity.AppUser;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.Gender;
import tn.esprit.Exception.UserNotFoundException;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface IUserService {



	AppUser updateUser(AppUser appUser) throws Exception;

	boolean deleteUser(int idUser);

	AppUser retrieveUserById(int idUser);

	List<AppUser> retrieveAllUsers();


	AppUser retrieveUserByUsername(String username);

	List<AppUser> retrieveUserByState(boolean stateUser);

	List<AppUser> retrieveUserByAdress(String adressUser);

	List<AppUser> retrieveUserByDate(Date birthDateUser);

	List<AppUser> retrieveUserByGender(Gender gender);

	Optional <AppUser> findBymail(String email);


	Optional<AppUser> findByRole(Role role);

	public AppUser activateUser (AppUser appUser) throws Exception;

	public AppUser desactivateUser (AppUser appUser) throws Exception;

	long retrieveUserByCount();

	public List<String> findUsersActivated() throws Exception;

	public List<String> getUsersFromDisabled();

	public void increaseFailedAttempts(AppUser appUser);

	boolean unlockWhenTimeExpired(AppUser appUser);

	void resetFailedAttempts(String email);

	void lock(AppUser appUser);

	//public AppUser findUserByResetToken(String token);

	void updateResettoken(String token, String email) throws UserNotFoundException;

	AppUser get(String resettoken);

	//void updatePassword(AppUser appUser, String newPassword);

	AppUser getByResettoken(String token);

	void forgotpass(String email);



	void updatePassword(String email, String newPassword, String confirmPassword);

	void save(AppUser appUser);
	AppUser saveUser(AppUser appUser);
	ResponseEntity<?> addAdmin(AppUser admin);
	ResponseEntity<?> addMember(AppUser member);
	boolean existsEmail(String email);
	Optional<AppUser> getByEmail(String email);



}


