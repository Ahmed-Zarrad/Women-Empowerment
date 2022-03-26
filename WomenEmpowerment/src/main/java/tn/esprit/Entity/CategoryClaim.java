package tn.esprit.Entity;

import java.io.Serializable;
 import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
