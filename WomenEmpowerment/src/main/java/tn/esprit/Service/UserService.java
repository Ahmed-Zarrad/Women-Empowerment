package tn.esprit.Service;

import org.springframework.stereotype.Repository;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.Userx;

import java.util.List;

@Repository
public interface UserService {

	List<Userx> retrieveAllUsers ();
	Userx addUser(Userx u);
	void deleteUser (Long idUser);
	Userx updateUser(Userx u);
	Userx retrieveUser(Long idUser);
	Userx retrieveUserByEmail(String email);
	List<Userx> retrieveUserById(Long idUser);
	Long countUser();
	int findUserByRole(Role role);
}
