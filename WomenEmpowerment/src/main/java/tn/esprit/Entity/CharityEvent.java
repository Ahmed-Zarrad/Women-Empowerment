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
public class CharityEvent implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idEvent;
	
	@Temporal(TemporalType.DATE)
	private Date StartDateEvent  ;
	
	@Temporal(TemporalType.DATE)
	private Date EndDateEvent  ;
	
	private String Location;
	private int Participants;
	private String TitleEvent;

	@JsonIgnore
	@OneToOne
	private Reservation reservation;

	@OneToOne(fetch = FetchType.EAGER)
	private Cagnotte cagnotte;
	
	

}
