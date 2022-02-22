package tn.esprit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobOffre implements Serializable  {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	
	
	private int idOffre;
	private String TitleOffre ;
	private float Salary ;
	private String offreDescription ;


	@JsonIgnore
	@OneToMany( mappedBy="JobOffres")
	private List <Condidat> condidats;

}
