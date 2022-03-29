package tn.esprit.Entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryClaim implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Id
		private int id;
		
		private String lib;
		@OneToMany(cascade = CascadeType.ALL , mappedBy="categoryclaim")
		private List <Category_KEY> category_KEYs;
		@OneToMany(cascade = CascadeType.ALL , mappedBy="categoryclaim")
		private List <Claim> Claims;
		 
		

}
