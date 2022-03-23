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
public class Membership implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMem;
    private String nameMem;
    private String DescriptionMem;
    private Date StartDateMem;
    private String DurationMem;
    private String QRCodeMem;

    @JsonIgnore
    @OneToOne
    private Userx userx;

}
