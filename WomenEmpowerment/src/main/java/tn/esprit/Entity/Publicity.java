package tn.esprit.Entity;

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
public class Publicity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Id
	
	
	private int IdPub ;
	
	private String TypePub ;
	
	private String NamePub ;
	
	@Temporal(TemporalType.DATE)
	private Date StartDatePub  ;
	
	@Temporal(TemporalType.DATE)
	private Date EndDatePub  ;
	
	private int InitialViewNumberPub  ;
	
	private int FinalViewNumberPub  ;
	
	private float PricePub   ;
	
	private String ChannelPub  ;
	
	private String TargetPub ;
	
	private Boolean CostPub ;
	
	private String MailOwnerPub ;
	
	private int PhoneOwnerPub;
	
	private String DescriptionPub ;
	
	
 
	
	
	@ManyToOne
    User user;
}
