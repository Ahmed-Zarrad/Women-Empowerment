package tn.esprit.Controller;


import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.User;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.*;

import tn.esprit.Entity.Role;
import tn.esprit.security.JwtUserDetailsService;
import tn.esprit.config.JwtTokenUtil;
import tn.esprit.Response.JwtRequest;
import tn.esprit.Response.JwtResponse;
import tn.esprit.security.UserDetailsImpl;
import tn.esprit.Service.IEmailService;
import tn.esprit.Service.IUserService;
import tn.esprit.dto.TokenDto;
import tn.esprit.Entity.AppUser;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin("*")
public class JwtAuthenticationController {

	@Value("${google.clientId}")
	String googleClientId;

	@Value("${secretPsw}")
	String secretPsw;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;


	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	IUserService us;
	
	@Autowired
	IEmailService es;
	
	@Autowired
	private JavaMailSender jms;


	// http://localhost:9091/SpringMVC/servlet/authenticate
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

		authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);
		final String name = jwtTokenUtil.getUsernameFromToken(token);

		return ResponseEntity.ok(new JwtResponse(token,userDetails.getUsername(),userDetails.getAuthorities()));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}

	
	}

	@PostMapping("/google")
	public ResponseEntity<TokenDto> google(@RequestBody TokenDto tokenDto) throws IOException {
		final NetHttpTransport transport = new NetHttpTransport();
		final JacksonFactory jacksonFactory = JacksonFactory.getDefaultInstance();
		GoogleIdTokenVerifier.Builder verifier =
				new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
						.setAudience(Collections.singletonList(googleClientId));
		final GoogleIdToken googleIdToken = GoogleIdToken.parse(verifier.getJsonFactory(), tokenDto.getValue());
		final GoogleIdToken.Payload payload = googleIdToken.getPayload();
		AppUser appUser = new AppUser();
		if(us.existsEmail(payload.getEmail()))
			appUser = us.getByEmail(payload.getEmail()).get();
		else
			appUser = saveAppUser(payload.getEmail());
		TokenDto tokenRes = login(appUser);
		return new ResponseEntity(tokenRes, HttpStatus.OK);
	}

	@PostMapping("/facebook")
	public ResponseEntity<TokenDto> facebook(@RequestBody TokenDto tokenDto) throws IOException {
		Facebook facebook = new FacebookTemplate(tokenDto.getValue());
		final String [] fields = {"email", "picture"};
		User user = facebook.fetchObject("me", User.class, fields);
		AppUser appUser = new AppUser();
		if(us.existsEmail(user.getEmail()))
			appUser = us.getByEmail(user.getEmail()).get();
		else
			appUser = saveAppUser(user.getEmail());
		TokenDto tokenRes = login(appUser);
		return new ResponseEntity(tokenRes, HttpStatus.OK);
	}

	private TokenDto login(AppUser appUser){
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(appUser.getEmail(), secretPsw)
		);
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtTokenUtil.generateToken2(authentication);
		TokenDto tokenDto = new TokenDto();
		tokenDto.setValue(jwt);
		return tokenDto;
	}

	private AppUser saveAppUser(String email){
		AppUser appUser = new AppUser(email, encoder.encode(secretPsw));
		 //appUser = us.findByRole(Role.Member).get();
		appUser.setRole(Role.Member);
		return us.saveUser(appUser);
	}

}
