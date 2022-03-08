package tn.esprit.Entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity

public class AppUser implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
		
		private Long idUser ;

		@Enumerated(EnumType.STRING)
		private Role role ;
		
		private String firstName;
		
		private String lastName;
		
		private int phoneNumber;
		
		private String email;
		
		private String password;
		
		private String gender;
		
		@Temporal(TemporalType.DATE)
		private Date birthDate;
		
		private String adress ;


	@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL , mappedBy="appUser")

		private List <Claim> claims;
	@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL , mappedBy="appUser")

		private List <Appointement> Appointements;
	@JsonIgnore
		@OneToOne(cascade=CascadeType.ALL , mappedBy = "appUser")

		private Membership membership;
	@JsonIgnore
		@OneToMany(cascade=CascadeType.ALL , mappedBy="appUser")
		private List<Comment> comments;
	@JsonIgnore
		@OneToMany(cascade=CascadeType.ALL , mappedBy="appUser")
		private List<Publicity> publicitys;
	@JsonIgnore
		@OneToOne(cascade=CascadeType.ALL , mappedBy = "appUser")
		private Reservation reservation;
	public AppUser() {}

	public AppUser(String firstName, String lastName, int phoneNumber, String email, String password, String gender, String adress) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.birthDate = birthDate;
		this.adress = adress;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}
}
