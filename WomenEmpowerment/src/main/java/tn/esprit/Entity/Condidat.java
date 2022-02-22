package tn.esprit.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Condidat implements Serializable   {
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	
	private int idcondidat ;
	private  String FirstName ;
	private String LastName ;
	private int PhoneNumber ;
	private String Email ;
	private String password ;
	private String Gender ;
	private String Image ;
	@Temporal(TemporalType.DATE)
	private Date BirthDate ;
	private String Adress ;
	@Enumerated(EnumType.STRING)
	private Status status ;
	
	@ManyToOne 
	JobOffre JobOffres ;
	
	
	
	
	

}
