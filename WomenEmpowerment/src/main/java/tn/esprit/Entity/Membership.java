package tn.esprit.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Membership implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMem;
    private String nameMem;
    private String DescriptionMem;
    private Date StartDateMem;
    private String DurationMem;
    private String QRCodeMem;

    @OneToOne
    private User user;

}
