package tn.esprit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.Condidat;
import tn.esprit.Entity.JobOffre;
import tn.esprit.Entity.Status;
import tn.esprit.repository.CondidatRepository;
import tn.esprit.repository.JobOffreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CondidatService {

    @Autowired
    private CondidatRepository condidatRepository ;

    @Autowired
    private JobOffreRepository jobOffreRepository ;

    @Autowired
    private JobOffreService jobOffreService;

    // Create condidat
    public Condidat addCondidat(Condidat condidat){
        return condidatRepository.save(condidat);
    }
    //delete Condidat by Id
    public void deleteCondidat(Long condidatId){
        condidatRepository.deleteById(condidatId);
    }

    // get all condidats
    public List<Condidat> retrieveAllCondidats(){
        return condidatRepository.findAll();
    }

    // get condidat by id
    public Optional<Condidat> getCondidatById(Long id){
        return condidatRepository.findById(id);
    }

    //filter condidats with status
    public List<Condidat> getCondidatByStatus(String status){
        return condidatRepository.findByStatusEquals(status);
    }




}
