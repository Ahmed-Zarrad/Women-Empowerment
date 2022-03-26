package tn.esprit.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
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

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category_KEY implements Serializable {
		private static final long serialVersionUID = 1L;
			
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Id
			private int	 id;
			
			private String textKey;
			@JsonIgnore
			@ManyToOne
			CategoryClaim categoryclaim ;

}
