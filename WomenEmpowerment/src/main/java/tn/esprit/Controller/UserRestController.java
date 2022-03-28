package tn.esprit.Controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.Entity.AppUser;
import tn.esprit.Entity.Role;
import tn.esprit.Repository.IUserRepository;
import tn.esprit.Response.Response;
import tn.esprit.Service.IUserService;

import javax.servlet.ServletContext;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin("*")
public class UserRestController {

	@Autowired
	IUserRepository ur;
	
	@Autowired
	IUserService us;
	
	@Autowired
	ServletContext context;

	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PostMapping("/add-admin")
	@ResponseBody
	public ResponseEntity<?> addAdmin (@RequestBody AppUser admin) {
		return us.addAdmin(admin);
	}

	@PostMapping("/add-member")
	@ResponseBody
	public ResponseEntity<?> addMember (@RequestBody AppUser member) {
		return us.addMember(member);

	}

	@PostMapping("/add-user")
	@ResponseBody
	public void save (@RequestBody AppUser appUser) {
		 us.save(appUser);

	}


	// http://localhost:9091/SpringMVC/servlet/delete-user/{appUser-id}
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@DeleteMapping("/delete-user/{idUser}")
	@ResponseBody
	public void deleteUser(@PathVariable("idUser") int userId) {
	us.deleteUser(userId);
	}
	
	// http://localhost:9091/SpringMVC/servlet/update-user
	@PutMapping("/update-user")
	@ResponseBody
	public AppUser updateUser(@RequestBody AppUser appUser) throws Exception {
	return us.updateUser(appUser);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-all-user
	//@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-all-user")
	@ResponseBody
	public List<AppUser> getUser() {
	List<AppUser> appUsers = us.retrieveAllUsers();
	return appUsers;
	}
			
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-id/{appUser-id}
	@GetMapping("/retrieve-user-by-id/{user-id}")
	@ResponseBody
	public AppUser retrieveUserById(@PathVariable("user-id") int userId) {
	return us.retrieveUserById(userId);
	}
	

	
	// http://localhost:9091/SpringMVC/servlet/retrieve-member-by-username/{appUser-username}
	@GetMapping("/retrieve-user-by-username/{user-username}")
	@ResponseBody
	public AppUser retrieveUserByFirstName(@PathVariable("user-username") String username) {
	return us.retrieveUserByUsername(username);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-state/{appUser-state}
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-user-by-state/{user-state}")
	@ResponseBody
	public List<AppUser> retrieveUserByState(@PathVariable("user-state") boolean stateUser) {
	return us.retrieveUserByState(stateUser);
	}	
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-adress/{appUser-adress}
	@GetMapping("/retrieve-user-by-adress/{user-adress}")
	@ResponseBody
	public List<AppUser> retrieveUserByAdress(@PathVariable("user-adress") String adressUser) {
	return us.retrieveUserByAdress(adressUser);
	}
				
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-date/{appUser-date}
	@GetMapping("/retrieve-user-by-date/{user-date}")
	@ResponseBody
	public List<AppUser> retrieveUserByDate(@PathVariable("user-date") Date birthDateUser) {
	return us.retrieveUserByDate(birthDateUser);
	}
				
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-gender/{appUser-gender}
	@GetMapping("/retrieve-user-by-gender/{user-gender}")
	@ResponseBody
	public List<AppUser> retrieveUserByGender(@PathVariable("user-gender") tn.esprit.Entity.Gender gender) {
	return us.retrieveUserByGender(gender);
	}
	
	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-email/{appUser-email}
	@GetMapping("/retrieve-user-by-email/{user-email}")
	@ResponseBody
	public AppUser retrieveUserByEmail(@PathVariable("user-email") String email) {
	return us.findBymail(email).get();
	}
	

	// http://localhost:9091/SpringMVC/servlet/retrieve-user-by-role/{appUser-role}
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/retrieve-user-by-role/{user-role}")
	@ResponseBody
	public Optional<AppUser> retrieveUserByGender(@PathVariable("user-role") Role role) {
	return us.findByRole(role);
	}
	
	// http://localhost:9091/SpringMVC/servlet/users-names
	@GetMapping("/users-names")
	public List<String> getAllUsersNames() throws Exception {
	return ur.getAllMemberNames();
	}
	
	// http://localhost:9091/SpringMVC/servlet/activate-user
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PutMapping("/activate-user")
	public AppUser activateUser(@RequestBody AppUser appUser) throws Exception {
	return us.activateUser(appUser);
	}
	
	// http://localhost:9091/SpringMVC/servlet/desactivate-User
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@PutMapping("/desactivate-User")
	public AppUser desactivateUser(@RequestBody AppUser appUser) throws Exception {
	return us.desactivateUser(appUser);
	}
	
	// http://localhost:9091/SpringMVC/servlet/count-user
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/count-user")
	@ResponseBody
	public long retrieveMemberByCount() {
	return us.retrieveUserByCount();
	}
	
	// http://localhost:9091/SpringMVC/servlet/findActivatedUser
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/findActivatedUser")
	public List<String> findUserActivated() throws Exception {
		return us.findUsersActivated();
	}

	// http://localhost:9091/SpringMVC/servlet/findDisabledUser
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/findDisabledUser")
	public List<String> findUserDisabled() throws Exception {
		return us.getUsersFromDisabled();
	}

	
	// http://localhost:9091/SpringMVC/servlet/min-age
	@PreAuthorize("hasAuthority('ADMINISTRATOR')")
	@GetMapping("/min-age")
	public Date agemin() throws Exception {
	return ur.getminage();
	}
	
	@GetMapping("/sendme/{email}")
	public void forgotpass(@PathVariable ("email") String email){
		us.forgotpass(email);
	}
	
	@PutMapping("/updatepassword/{email}/{password}/{cpassword}")
	void updatePassword(@PathVariable ("email") String email, @PathVariable ("password") String newPassword,@PathVariable ("cpassword") String confirmPassword){
		us.updatePassword(email, newPassword,confirmPassword);
	}
	
	
	
	 @PostMapping("/userss")
	 public ResponseEntity<Response> createUser (@RequestParam("file") MultipartFile file,
			 @RequestParam("article") String product) throws JsonParseException , JsonMappingException , Exception
	 {
		 System.out.println("Ok .............");
        AppUser prod = new ObjectMapper().readValue(product, AppUser.class);
        boolean isExit = new File(context.getRealPath("/Images/")).exists();
        if (!isExit)
        {
        	new File (context.getRealPath("/Images/")).mkdir();
        	System.out.println("mk dir.............");
        }
        String filename = file.getOriginalFilename();
        String newFileName = FilenameUtils.getBaseName(filename)+"."+FilenameUtils.getExtension(filename);
        File serverFile = new File (context.getRealPath("/Images/"+File.separator+newFileName));
        try
        {
        	System.out.println("Image");
        	 FileUtils.writeByteArrayToFile(serverFile,file.getBytes());
        	 
        }catch(Exception e) {
        	e.printStackTrace();
        }

       
        prod.setFileName(newFileName);
        AppUser art = ur.save(prod);
        if (art != null)
        {
        	return new ResponseEntity<Response>(new Response (""),HttpStatus.OK);
        }
        else
        {
        	return new ResponseEntity<Response>(new Response ("AppUser not saved"),HttpStatus.BAD_REQUEST);
        }
	 }
	 
	// http://localhost:9090/SpringMVC/servlet/Imgarticles/{id}
			@GetMapping("/Imguserss/{id}")
			 public byte[] getPhotos(@PathVariable("id") int id) throws Exception{
				 AppUser prod  = ur.findById(id).get();
				 return Files.readAllBytes(Paths.get(context.getRealPath("/Images/")+prod.getFileName()));
			 }
}
