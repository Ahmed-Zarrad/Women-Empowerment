package tn.esprit.Response;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;


public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private String jwttoken;
	private String type = "Bearer";
	private String email ;
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public JwtResponse(String jwttoken) {
		super();
		this.jwttoken = jwttoken;
		
	}


	public JwtResponse(String jwttoken, String email, Collection<? extends GrantedAuthority> collection) {
		this.jwttoken = jwttoken;
		this.email = email;
		this.authorities = collection;
	}


	public String getJwttoken() {
		return jwttoken;
	}


	public void setJwttoken(String jwttoken) {
		this.jwttoken = jwttoken;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}


	public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	
	
}