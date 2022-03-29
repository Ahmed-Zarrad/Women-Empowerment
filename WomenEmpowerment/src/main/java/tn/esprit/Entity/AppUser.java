package tn.esprit.Entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

@Table (name = "APPUSER")
public class AppUser implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idUser;
	@Enumerated(EnumType.STRING)
	private Role role;
	protected String username;
	protected String lastNameUser;
	protected String password;
	protected String confirmPasswordUser;
	protected boolean stateUser;
	protected int phoneNumberUser;
	protected String adressUser;
	@Temporal(TemporalType.DATE)
	protected Date birthDateUser;
	protected String email;
	@Enumerated(EnumType.STRING)
	protected Gender gender;
	protected boolean accountNonLocked;
	@Column(name = "failedAttempt", columnDefinition = "int default 0")
	protected int failedAttempt;
	@Column(name = "lockTime")
	protected Date lockTime;
	protected String  resettoken;
	protected boolean isBlocked;
	protected LocalDate blockDate;
	protected LocalDate unBlockDate;
	protected boolean avilaibility;
	private String fileName;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser")

	private List<Claim> claims;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser")

	private List<Appointement> Appointements;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "appUser")

	private Membership membership;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser")
	private List<Comment> comments;
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "appUser")
	private List<Publicity> publicitys;
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "appUser")
	private Reservation reservation;
	@OneToMany(cascade = CascadeType.ALL)
	private Set<ImageUser> ImageUser1;


	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLastNameUser() {
		return lastNameUser;
	}

	public void setLastNameUser(String lastNameUser) {
		this.lastNameUser = lastNameUser;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPasswordUser() {
		return confirmPasswordUser;
	}

	public void setConfirmPasswordUser(String confirmPasswordUser) {
		this.confirmPasswordUser = confirmPasswordUser;
	}

	public boolean isStateUser() {
		return stateUser;
	}

	public void setStateUser(boolean stateUser) {
		this.stateUser = stateUser;
	}

	public int getPhoneNumberUser() {
		return phoneNumberUser;
	}

	public void setPhoneNumberUser(int phoneNumberUser) {
		this.phoneNumberUser = phoneNumberUser;
	}

	public String getAdressUser() {
		return adressUser;
	}

	public void setAdressUser(String adressUser) {
		this.adressUser = adressUser;
	}

	public Date getBirthDateUser() {
		return birthDateUser;
	}

	public void setBirthDateUser(Date birthDateUser) {
		this.birthDateUser = birthDateUser;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public boolean isAccountNonLocked() {
		return accountNonLocked;
	}

	public void setAccountNonLocked(boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}

	public int getFailedAttempt() {
		return failedAttempt;
	}

	public void setFailedAttempt(int failedAttempt) {
		this.failedAttempt = failedAttempt;
	}

	public Date getLockTime() {
		return lockTime;
	}

	public void setLockTime(Date lockTime) {
		this.lockTime = lockTime;
	}

	public String getResettoken() {
		return resettoken;
	}

	public void setResettoken(String resettoken) {
		this.resettoken = resettoken;
	}

	public boolean isBlocked() {
		return isBlocked;
	}

	public void setBlocked(boolean blocked) {
		isBlocked = blocked;
	}

	public LocalDate getBlockDate() {
		return blockDate;
	}

	public void setBlockDate(LocalDate blockDate) {
		this.blockDate = blockDate;
	}

	public LocalDate getUnBlockDate() {
		return unBlockDate;
	}

	public void setUnBlockDate(LocalDate unBlockDate) {
		this.unBlockDate = unBlockDate;
	}

	public boolean isAvilaibility() {
		return avilaibility;
	}

	public void setAvilaibility(boolean avilaibility) {
		this.avilaibility = avilaibility;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public List<Appointement> getAppointements() {
		return Appointements;
	}

	public void setAppointements(List<Appointement> appointements) {
		Appointements = appointements;
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Publicity> getPublicitys() {
		return publicitys;
	}

	public void setPublicitys(List<Publicity> publicitys) {
		this.publicitys = publicitys;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public Set<ImageUser> getImageUser1() {
		return ImageUser1;
	}


	public void setImageUser1(Set<ImageUser> imageUser1) {
		ImageUser1 = imageUser1;

	}

	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppUser(int idUser, Role role, String username, String lastNameUser, String password, String confirmPasswordUser,
				   boolean stateUser, int phoneNumberUser, String adressUser, Date birthDateUser, String email,
				   Gender gender, boolean accountNonLocked, int failedAttempt, Date lockTime, String resettoken,
				   boolean isBlocked, LocalDate blockDate, LocalDate unBlockDate, boolean avilaibility, String fileName,
				   List<Claim> claims, List<Appointement> appointements, Membership membership, List<Comment> comments,
				   List<Publicity> publicitys, Reservation reservation, Set<ImageUser> imageUser1) {
		this.idUser = idUser;
		this.role = role;
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.birthDateUser = birthDateUser;
		this.email = email;
		this.gender = gender;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;
		this.lockTime = lockTime;
		this.resettoken = resettoken;
		this.isBlocked = isBlocked;
		this.blockDate = blockDate;
		this.unBlockDate = unBlockDate;
		this.avilaibility = avilaibility;
		this.fileName = fileName;
		//this.claims = claims;
		//Appointements = appointements;
		//this.membership = membership;
		//this.comments = comments;
		//this.publicitys = publicitys;
		//this.reservation = reservation;
		//ImageUser1 = imageUser1;
	}

	public AppUser(Role role, String username, String lastNameUser, String password, String confirmPasswordUser,
				   boolean stateUser, int phoneNumberUser, String adressUser, String email, Gender gender,
				   boolean accountNonLocked, int failedAttempt, boolean isBlocked,
				   boolean avilaibility) {
		this.role = role;
		this.username = username;
		this.lastNameUser = lastNameUser;
		this.password = password;
		this.confirmPasswordUser = confirmPasswordUser;
		this.stateUser = stateUser;
		this.phoneNumberUser = phoneNumberUser;
		this.adressUser = adressUser;
		this.email = email;
		this.gender = gender;
		this.accountNonLocked = accountNonLocked;
		this.failedAttempt = failedAttempt;

		this.isBlocked = isBlocked;

		this.avilaibility = avilaibility;


	}

	public AppUser( String email,String password) {
		this.password = password;
		this.email = email;
	}
}