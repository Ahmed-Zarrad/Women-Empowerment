package tn.esprit.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reservation implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
		
		private int idResevation;
		
		@OneToOne (fetch = FetchType.EAGER)
		private CharityEvent charityEvent;
		@OneToOne
		private User user;


}
