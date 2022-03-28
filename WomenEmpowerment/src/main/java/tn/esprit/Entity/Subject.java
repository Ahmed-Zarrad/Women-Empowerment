package tn.esprit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Subject implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	
	
	private int idSub ;
	
	private String titleSub;
	
	
	@Temporal(TemporalType.DATE)
	private Date Datesub  ;
	
	private String description;
	
	private int starsNumberSubject ;
	
	
	
	@JsonIgnore
	@OneToMany(cascade=CascadeType.ALL , mappedBy="subject")
	 private List<Comment> comments;
	
	
	
	
	
	
	@JsonIgnore
	@ManyToOne
	private Userx userx;
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy="subject")
	private List <Liking> likingSubject;
	
	
	

	
	
	

}
