package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.OffreFavori;
import tn.esprit.repository.OffreFavoriRepository;

@Service
public class OffreFavoriService {

    @Autowired
    private OffreFavoriRepository offreFavoriRepository;

    public OffreFavori addJobOffreFavori(OffreFavori offreFavori){
        return offreFavoriRepository.save(offreFavori);
    }


}
