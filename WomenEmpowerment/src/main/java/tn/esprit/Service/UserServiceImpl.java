package tn.esprit.Service;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.AppUser;
import tn.esprit.Entity.Role;
import tn.esprit.Entity.Gender;
import tn.esprit.Exception.UserNotFoundException;
import tn.esprit.Repository.IUserRepository;
import tn.esprit.Response.ResponseMessage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.*;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	IUserRepository ur;
	
	@Autowired
	IUserService us;

	@Autowired
	PasswordEncoder encoder;

	

	@Override
	public void forgotpass(String email) {
		// TODO Auto-generated method stub
		AppUser d = ur.findByEmail(email);
		/* com.twilio.rest.api.v2010.account.Message.creator(new PhoneNumber("+21655717442"), new PhoneNumber("+19286429132"),
		         "Votre commande a été confirmée").create();*/
        final String username = "x.gym.unkowen.team@gmail.com";
        final String password = "ahmed,123";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("x.gym.unkowen.team@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject("Rest Your Password");
            message.setText("Welcom To Women Empowerment \n "
            		+"Dear Member \n"
                    + "Please follow the following link : \n" + "http://localhost:9091/SpringMVC/servlet/updatepassword/{email}/{password}/{cpassword}");

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    

		
	}



	@Override
	public void save(AppUser appUser) {
		appUser.setPassword(encoder.encode(appUser.getPassword()));
		appUser.setConfirmPasswordUser(encoder.encode(appUser.getConfirmPasswordUser()));
		this.ur.save(appUser);
	}
	@Override
	public AppUser saveUser(AppUser appUser){
		return ur.save(appUser);
	}
	@Override
	public ResponseEntity<?> addAdmin(AppUser admin) {

		admin.setRole(Role.ADMINISTRATOR);
		admin.setStateUser(true);
		admin.setAccountNonLocked(true);
		admin.setFailedAttempt(0);


		if (admin == null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add values!"));
		}
		if (!admin.getPassword().equals(admin.getConfirmPasswordUser())) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Confirm your password!"));}
		else {admin.setPassword(encoder.encode(admin.getPassword()));
			admin.setConfirmPasswordUser(encoder.encode(admin.getConfirmPasswordUser()));}
		if (admin.getAdressUser().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add address!"));
		}

		if (!(admin.getBirthDateUser() instanceof Date)) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add bithday date!"));
		}
		if (admin.getUsername().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add your first name!"));
		}
		if (admin.getEmail().equals("") || !UserServiceImpl.validate(admin.getEmail())) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please check your mail!"));
		}
		if (us.retrieveUserByUsername(admin.getUsername()) != null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: Username is already taken!"));
		}
		if (us.findBymail(admin.getEmail()) != null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: Email is already taken!"));
		}
		this.ur.save(admin);
		return ResponseEntity.ok(new ResponseMessage("appUser added Succefully"));

	}
	@Override
	public ResponseEntity<?> addMember(AppUser member) {

		member.setRole(Role.Member);
		member.setStateUser(true);
		member.setAccountNonLocked(true);
		member.setFailedAttempt(0);


		if (member == null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add values!"));
		}

		if (!member.getConfirmPasswordUser().equals(member.getPassword()))  {
			return ResponseEntity.badRequest().body(new ResponseMessage("Confirm your password!"));}
		else {member.setPassword(encoder.encode(member.getPassword()));
			member.setConfirmPasswordUser(encoder.encode(member.getConfirmPasswordUser()));}
		if (member.getAdressUser().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add address!"));
		}

		if (!(member.getBirthDateUser() instanceof Date)) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add bithday date!"));
		}
		if (member.getUsername().equals("")) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please add your first name!"));
		}
		if (member.getEmail().equals("") || !UserServiceImpl.validate(member.getEmail())) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: please check your mail!"));
		}
		if (us.retrieveUserByUsername(member.getUsername()) != null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: Username is already taken!"));
		}
		if (us.findBymail(member.getEmail()) != null) {
			return ResponseEntity.badRequest().body(new ResponseMessage("Error: Email is already taken!"));
		}

		this.ur.save(member);
		return ResponseEntity.ok(new ResponseMessage("Member added Succefully"));
	}


	@Override
	public void updateResettoken(String token, String email) throws UserNotFoundException{
		AppUser appUser = ur.findByEmail(email);
		if (appUser != null){
			appUser.setResettoken(token);
			ur.save(appUser);
		}else{
			throw new UserNotFoundException("could not find AppUser with email" + email);
		}
	}
	
	@Override
	public AppUser get(String resettoken){
		return ur.findByResettoken(resettoken);
	}
	
	
	@Override
	public AppUser updateUser(@RequestBody AppUser appUser) throws Exception {
		AppUser userinthedatabase = us.retrieveUserById(appUser.getIdUser());
		if (!encoder.encode(appUser.getPassword()).equals(userinthedatabase.getPassword()) && !encoder.encode(appUser.getConfirmPasswordUser()).equals(userinthedatabase.getConfirmPasswordUser())) {
			appUser.setPassword(encoder.encode(appUser.getPassword()));
			appUser.setPassword(encoder.encode(appUser.getConfirmPasswordUser()));
		}
		return ur.save(appUser);
	}

	@Override
	public boolean deleteUser(int idUser) {
		if (ur.existsById(idUser)){
			ur.deleteById(idUser);
			return true;
		}else
		return false;
	}

	@Override
	public AppUser retrieveUserById(int idUser) {
		return ur.findById(idUser).get();
	}

	@Override
	public List<AppUser> retrieveAllUsers() {
		return (List<AppUser>) ur.findAll();
	}



	@Override
	public AppUser retrieveUserByUsername(String username) {
		return ur.findByUsername(username);
	}

	@Override
	public List<AppUser> retrieveUserByState(boolean stateUser) {
		return ur.findByStateUser(stateUser);
	}

	@Override
	public List<AppUser> retrieveUserByAdress(String adressUser) {
		return ur.findByAdressUser(adressUser);
	}

	@Override
	public List<AppUser> retrieveUserByDate(Date birthDateUser) {
		return ur.findByBirthDateUser(birthDateUser);
	}

	@Override
	public List<AppUser> retrieveUserByGender(Gender gender) {
		return ur.findByGender(gender);
	}

	@Override
	public AppUser activateUser (AppUser appUser) throws Exception {
		appUser.setStateUser(true);
		return updateUser(appUser);
	}

	@Override
	public AppUser desactivateUser (AppUser appUser) throws Exception {
		appUser.setStateUser(false);
		return updateUser(appUser);
	}

	@Override
	public long retrieveUserByCount() {
		return ur.count();
	}

	@Override
	public List<String> findUsersActivated() throws Exception {
		return ur.getUsersFromActivated();
	}

	@Override
	public List<String> getUsersFromDisabled() {
		return ur.getUsersFromDisabled();
	}

	@Override
    public boolean unlockWhenTimeExpired(AppUser appUser) {
        long lockTimeInMillis = appUser.getLockTime().getTime();
        long currentTimeInMillis = System.currentTimeMillis();
         
        if (lockTimeInMillis < currentTimeInMillis) {
            appUser.setAccountNonLocked(true);
            appUser.setLockTime(null);
            appUser.setFailedAttempt(0);
            ur.save(appUser);
             
            return true;
        }
        return false;
    }
	public static boolean validate(String emailStr) {
        boolean matcher = emailStr != null;
        return matcher;
}

	 @Override
	    public void resetFailedAttempts(String email) {
	    }

	 @Override
	    public void lock(AppUser appUser) {
	        appUser.setAccountNonLocked(false);
	        appUser.setLockTime(new Date());
	        ur.save(appUser);
	    }
	 
	 

	     
	    public AppUser getByResettoken(String token) {
	        return ur.findByResettoken(token);
	    }
	     
	    @Override
	    public void updatePassword(String email, String newPassword,String confirmPassword) {
	    	AppUser u = ur.findByEmail(email);
	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        String encodedPassword = passwordEncoder.encode(newPassword);
	        String encodedConfirmPassword = passwordEncoder.encode(confirmPassword);
	        u.setPassword(encodedPassword);
	        u.setConfirmPasswordUser(encodedConfirmPassword);
	         
	        u.setResettoken(null);
	        ur.save(u);
	    }

	@Override
	public  AppUser findBymail(String email) {
		return ur.findByEmail(email);
	}



	@Override
	public Optional<AppUser> findByRole(Role role) {
		return ur.findByRole(role);
	}

	@Override
	public void increaseFailedAttempts(AppUser appUser) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean existsEmail(String email){return ur.existsByEmail(email);}

	@Override
	public AppUser getByEmail(String email){
		return ur.findByEmail(email);
	}




}
