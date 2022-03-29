package tn.esprit.Entity;

import java.io.Serializable;




import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
	private Userx userx;

}
