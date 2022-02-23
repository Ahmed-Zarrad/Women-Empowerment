package tn.esprit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobOffre implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	
	
	private Integer idOffre;
	private String TitleOffre ;
	private Float Salary ;
	private String offreDescription ;


	@JsonIgnore
	@OneToMany( mappedBy="JobOffre")
	private List <Condidat> condidats;

}
