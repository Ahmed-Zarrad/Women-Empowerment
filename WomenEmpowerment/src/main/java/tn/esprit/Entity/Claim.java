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

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Claim implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
		
		private int IdClaim;
		
		private String TitleClaim;
		
		private String DescriptionClaim;
		
		@Temporal(TemporalType.DATE)
		private Date DateClaim ;
		@JsonIgnore
		@ManyToOne
        AppUser appUser;
		
		

}
