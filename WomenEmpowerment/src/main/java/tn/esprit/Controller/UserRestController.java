package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.AppUser;
import tn.esprit.Entity.Role;
import tn.esprit.Service.UserServiceImpl;

import java.util.List;

@RestController
public class UserRestController {
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/retrieve-all-users")	
	@ResponseBody
	public List<AppUser> getUsers(){
		List<AppUser> list = userService.retrieveAllUsers() ;
		return list; 
	}
	@GetMapping("/retrieve-all-users/{user-idUser}")
	@ResponseBody
	public AppUser retrieveUser(@PathVariable("user-idUser") Long userId) {
		return userService.retrieveUser(userId);
	}
	 
	@PostMapping("/add-user")
	@ResponseBody
	public AppUser addUser (@RequestBody AppUser u) {
		AppUser user = userService.addUser(u);
		return user;
	}

	
	@PutMapping("/modify-user")
	@ResponseBody
	public AppUser modifyUser(@RequestBody AppUser user) {
		return userService.updateAppUser(user);
	}
 
	@DeleteMapping("/remove-user/{user-idUser}")
	@ResponseBody
	public void removeUser(@PathVariable("user-idUser") Long userId) {
		userService.deleteUser(userId);
	}
	 
	@GetMapping("/retrieveUserByEmail/{email}")
	@ResponseBody
	public AppUser retrieveUserByEmail (@PathVariable("email") String email) {
		return userService.retrieveUserByEmail(email);
	}
	
	@GetMapping("/numberOfUsers")	
	@ResponseBody
	public Long countUser() {
		Long countUser= userService.countUser() ;
		return countUser;
	}
 
	@GetMapping("/countUserByRole/{role}")	
	@ResponseBody
	public int countUserByRole(@PathVariable("role") String role) {
		
//		System.out.println(Role.valueOf(role));
//		System.out.println(Role.valueOf("Member"));
		int countUserByRole= userService.findUserByRole(Role.valueOf(role));
		return countUserByRole;
	}
 
}
