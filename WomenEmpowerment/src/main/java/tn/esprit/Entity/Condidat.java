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
	private  String firstName ;
	private String lastName ;
	private Integer phoneNumber ;
	private String email ;
	private String password ;
	private String gender ;
	private String image ;
	@Temporal(TemporalType.DATE)
	private Date birthDate ;

	private String adress ;
	@Enumerated(EnumType.STRING)
	private Status status;
	@JsonIgnore
	@ManyToOne (fetch = FetchType.EAGER)
	JobOffre jobOffre ;
	@JsonIgnore
	@ManyToOne
	Userx userx ;

	
	
	
	
	

}
