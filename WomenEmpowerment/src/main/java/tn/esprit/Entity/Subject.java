package tn.esprit.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Subject implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	
	
	private int IdSub ;
	
	private String TitleSub;
	
	private int StarsNumber;
	
	private String Description;
	
	@OneToMany(cascade=CascadeType.ALL , mappedBy="subject")
	 private List<Comment> comments;
	
	

}
