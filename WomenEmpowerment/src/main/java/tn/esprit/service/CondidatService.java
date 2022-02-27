package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Condidat;
import tn.esprit.repository.CondidatRepository;

@Service
public class CondidatService {

    @Autowired
    private CondidatRepository condidatRepository ;

    // Create condidat
    public void addCondidat(Condidat condidat){
        condidatRepository.save(condidat);
    }

}
