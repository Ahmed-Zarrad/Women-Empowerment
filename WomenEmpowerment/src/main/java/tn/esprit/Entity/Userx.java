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
@Builder
public class Userx implements Serializable {

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

		private Boolean active;
	@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL , mappedBy="userx")

		private List <Claim> claims;
	@JsonIgnore
		@OneToMany(cascade = CascadeType.ALL , mappedBy="userx")

		private List <Appointement> Appointements;
	@JsonIgnore
		@OneToOne(cascade=CascadeType.ALL , mappedBy = "userx")

		private Membership membership;
	@JsonIgnore
		@OneToMany(cascade=CascadeType.ALL , mappedBy="userx")
		private List<Comment> comments;
	@JsonIgnore
		@OneToMany(cascade=CascadeType.ALL , mappedBy="userx")
		private List<Publicity> publicitys;
	@JsonIgnore
		@OneToOne(cascade=CascadeType.ALL , mappedBy = "userx")
		private Reservation reservation;

}
