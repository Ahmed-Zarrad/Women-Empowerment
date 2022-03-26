package tn.esprit.Entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
		
		private int Id ;

		@Enumerated(EnumType.STRING)
		private Role role ;
		
		private String FirstName;
		
		private String LastName;
		
		private int PhoneNumber;
		
		private String Email;
		
		private String Password;
		
		private String Gender;
		
		@Temporal(TemporalType.DATE)
		private Date BirthDate;
		
		private String Adress ;

		private Boolean active;
		
		@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
		private List <Claim> claims;
		@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL , mappedBy="user")
		private List <Appointement> Appointements;
		@JsonIgnore
		@OneToOne(cascade=CascadeType.ALL , mappedBy = "user")
		private Membership membership;
		@JsonIgnore
		@OneToMany(cascade=CascadeType.ALL , mappedBy="user")
		private List<Comment> comments;
		@JsonIgnore
		@OneToMany(cascade=CascadeType.ALL , mappedBy="user")
		private List<Publicity> publicitys;
		@JsonIgnore
		@OneToOne(cascade=CascadeType.ALL , mappedBy = "user")
		private Reservation reservation;

}
