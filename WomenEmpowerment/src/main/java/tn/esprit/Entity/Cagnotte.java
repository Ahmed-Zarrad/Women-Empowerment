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
public class Cagnotte implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	private int idCagnotte;
	
	private String nameCagnotte;
	
	private float amount;

	@JsonIgnore
	@OneToOne(mappedBy="cagnotte")
	private CharityEvent charityEvent;
	

}
