package tn.esprit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Liking implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private String idReact;
	
	@Enumerated(EnumType.STRING)
	private ReactType reactType;
	
	
	
	
	
	
	
	@JsonIgnore
	@ManyToOne
	private Subject subject;
	
	@JsonIgnore
	@ManyToOne
	private AppUser appUser;

}
