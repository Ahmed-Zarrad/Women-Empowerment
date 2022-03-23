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
	
	private int idCom ;
	
	
	private String descriptionCom ;

	@Temporal(TemporalType.DATE)
	private Date dateCom ;
	
	private Boolean state ;

	

	@JsonIgnore
	@ManyToOne
	Userx userx;
	
	
	@JsonIgnore
	@ManyToOne (fetch = FetchType.EAGER)
	Subject subject;

}
