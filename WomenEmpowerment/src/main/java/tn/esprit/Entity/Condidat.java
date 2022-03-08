package tn.esprit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Condidat implements Serializable   {
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id

	private Long idCondidat ;
	private  String FirstName ;
	private String LastName ;
	private Integer PhoneNumber ;
	private String Email ;
	private String password ;
	private String Gender ;
	private String Image ;
	@Temporal(TemporalType.DATE)
	private Date BirthDate ;

	private String Adress ;
	@Enumerated(EnumType.STRING)
	private Status status;
	@JsonIgnore
	@ManyToOne (fetch = FetchType.EAGER)
	JobOffre JobOffre ;
	@JsonIgnore
	@ManyToOne
    AppUser appUser ;

	
	
	
	
	

}
