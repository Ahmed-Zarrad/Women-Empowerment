package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.Userx;
import tn.esprit.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public List<Userx> retrieveAllUsers() {
		List<Userx> useres = (List<Userx>) userRepository.findAll();
		return useres;
	}

	@Override
	public Userx addUser(Userx u) {

		Userx user =userRepository.save(u);
		return user;
	}

	@Override
	public void deleteUser(Long idUser) {
		userRepository.deleteById(idUser);
		
	}

	@Override
	public Userx updateUser(Userx u) {
		Userx user=userRepository.save(u);
		return user;
	}

	@Override
	public Userx retrieveUser(Long idUser) {
		Optional<Userx> user=userRepository.findById(idUser);
		if (user != null ) {
			return user.get();
		}
		return null;
		
	}
	@Override
	public Userx retrieveUserByEmail(String email) {
		Userx user = userRepository.findUserByemail(email);
		return user;
	}
	
	@Override
	public List<Userx> retrieveUserById(Long idUser) {
		List<Userx> users = userRepository.findUserByID(idUser);
		return users;
	}

	public Long countUser() {
        return userRepository.count();
    }
	
	@Override
	public int findUserByRole(Role role) {
		 List<Userx>listUserByRole =  userRepository.findUserByRole(role);
		 int countUserByRole =  listUserByRole.size();
		return countUserByRole;
	}

	
}
