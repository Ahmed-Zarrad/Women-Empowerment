package tn.esprit.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

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
