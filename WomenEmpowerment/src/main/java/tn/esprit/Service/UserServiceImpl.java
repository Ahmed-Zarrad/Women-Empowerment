package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.AppUser;
import tn.esprit.Entity.Role;
import tn.esprit.Repository.UserRepository;
import tn.esprit.error.NotFoundException;
import org.springframework.http.ResponseEntity;
import tn.esprit.util.ResponseMessage;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Bean
	private PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new User("khalid",passwordEncoder().encode("password"), AuthorityUtils.NO_AUTHORITIES);
		AppUser user = userRepository.findByEmail(username);
		if (user == null) {
			throw new NotFoundException("User not found");
		}

		return user;
	}


	public void save(AppUser user) {
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		/*if (user == null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add values!"));
		}*/
		/*if (user.getPassword().equals(user.getConfirmPasswordUser() != null)) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Confirm your password!"));
		}*/
		/*if (user.getAdress().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add address!"));
		}
		if (user.getAdress().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add bithday date!"));
		}
		if (!(user.getBirthDate() instanceof Date)) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add bithday date!"));
		}
		if (user.getUsername().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add your first name!"));
		}*/
		/*if (user.getEmail().equals("") || !UserServiceImpl.validate(user.getEmail())) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please check your mail!"));
		}*/
		/*if (user.retrieveUserByUsername(user.getUsername()) != null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: Username is already taken!"));
		}*/
		/*if (user.findBymail(user.getEmail()) != null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: Email is already taken!"));
		}*/
		this.userRepository.save(user);
	}






	public List<AppUser> retrieveAllUsers() {
		List<AppUser> useres = (List<AppUser>) userRepository.findAll();
		return useres;
	}


	public AppUser addUser(AppUser u) {
		u.setPassword(passwordEncoder().encode(u.getPassword()));
		AppUser user =userRepository.save(u);
		return user;
	}


	public void deleteUser(Long idUser) {
		userRepository.deleteById(idUser);
		
	}


	public AppUser updateAppUser(AppUser u) {
		AppUser user=userRepository.save(u);
		return user;
	}


	public AppUser retrieveUser(Long idUser) {
		Optional<AppUser> user=userRepository.findById(idUser);
		if (user != null ) {
			return user.get();
		}
		return null;
		
	}

	public AppUser retrieveUserByEmail(String email) {
		AppUser user = userRepository.findUserByemail(email);
		return user;
	}
	

	public List<AppUser> retrieveUserById(Long idUser) {
		List<AppUser> users = userRepository.findUserByID(idUser);
		return users;
	}

	public Long countUser() {
        return userRepository.count();
    }
	

	public int findUserByRole(Role role) {
		 List<AppUser>listUserByRole =  userRepository.findUserByRole(role);
		 int countUserByRole =  listUserByRole.size();
		return countUserByRole;
	}

	
}
