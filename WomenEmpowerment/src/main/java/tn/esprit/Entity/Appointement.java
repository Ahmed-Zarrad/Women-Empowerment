package tn.esprit.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Appointement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
	 
	
	private int IdApp;
	
	@Temporal(TemporalType.DATE)
	private Date DateApp ;
	
	private int UserNumApp;
	
	private String DescriptionApp ;
	@JsonIgnore
	@ManyToOne
	AppUser appUser;
	
}
