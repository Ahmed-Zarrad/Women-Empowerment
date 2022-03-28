package tn.esprit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment implements Serializable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	
	private int IdCom ;
	
	private int LikeNumber;
	
	private int DeslikeNumber ;
	
	private String DescriptionCom ;

	@Temporal(TemporalType.DATE)
	private Date DateCom ;
	
	private Boolean State ;

	@JsonIgnore
	@ManyToOne (fetch = FetchType.EAGER)
	Subject subject;

	@JsonIgnore
	@ManyToOne
    AppUser appUser;

}
