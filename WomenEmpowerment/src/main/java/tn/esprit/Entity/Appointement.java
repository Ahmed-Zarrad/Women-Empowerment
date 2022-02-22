package tn.esprit.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.*;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
	
	@ManyToOne
    User accounts;
	
}
