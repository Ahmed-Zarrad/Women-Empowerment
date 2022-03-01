package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.Userx;
import tn.esprit.Service.UserService;

import java.util.List;

@RestController
public class UserRestController {
	@Autowired
	UserService userService;
	
	@GetMapping("/retrieve-all-users")	
	@ResponseBody
	public List<Userx> getUsers(){
		List<Userx> list = userService.retrieveAllUsers() ;
		return list; 
	}
	@GetMapping("/retrieve-all-users/{user-idUser}")
	@ResponseBody
	public Userx retrieveUser(@PathVariable("user-idUser") Long userId) {
		return userService.retrieveUser(userId);
	}
	 
	@PostMapping("/add-user")
	@ResponseBody
	public Userx addUser (@RequestBody Userx u) {
		Userx user = userService.addUser(u);
		return user;
	}
	
	@PutMapping("/modify-user")
	@ResponseBody
	public Userx modifyUser(@RequestBody Userx user) {
		return userService.updateUser(user);
	}
 
	@DeleteMapping("/remove-user/{user-idUser}")
	@ResponseBody
	public void removeUser(@PathVariable("user-idUser") Long userId) {
		userService.deleteUser(userId);
	}
	 
	@GetMapping("/retrieveUserByEmail/{email}")
	@ResponseBody
	public Userx retrieveUserByEmail (@PathVariable("email") String email) {
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
