package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Condidat;
import tn.esprit.Repository.CondidatRepository;
import tn.esprit.Service.CondidatService;

import java.util.List;

@RestController
public class CondidatController {

    @Autowired
    private CondidatService condidatService;

    @Autowired
    private CondidatRepository condidatRepository;

    // create
    @RequestMapping(value = "/CreateCondidat", method = RequestMethod.POST)
    public Condidat saveCondidat(@RequestBody Condidat condidat) {
        return condidatService.addCondidat(condidat);
    }


    //delete
    @RequestMapping(value = "/deleteCondidat", method = RequestMethod.DELETE)
    public void deleteCondidat(@RequestParam(name = "condidatId") final Long id) {
        condidatService.deleteCondidat(id);
    }

    //update
    @RequestMapping(value = "/updateCondidat", method = RequestMethod.PUT)
    Condidat updateCondidat(@RequestBody Condidat newCondidat, @RequestParam(name = "condidatId") final Long id) {

        return condidatRepository.findById(id)
                .map(condidat -> {
                    condidat.setUsername(newCondidat.getUsername());
                    condidat.setLastName(newCondidat.getLastName());
                    condidat.setPhoneNumber(newCondidat.getPhoneNumber());
                    condidat.setEmail(newCondidat.getEmail());
                    condidat.setPassword(newCondidat.getPassword());
                    condidat.setGender(newCondidat.getGender());
                    condidat.setImage(newCondidat.getImage());
                    condidat.setBirthDate(newCondidat.getBirthDate());
                    condidat.setAdress(newCondidat.getAdress());
                    condidat.setStatus(newCondidat.getStatus());

                    return condidatRepository.save(condidat);
                })
                .orElseGet(() -> {
                    return condidatRepository.save(newCondidat);
                });
    }

    //get all condidats
    @RequestMapping(value = "/condidats", method = RequestMethod.GET)
    public List<Condidat> getAllCondidats() {
        return condidatService.retrieveAllCondidats();
    }

    // get condidat by id
    @RequestMapping(value = "/condidat", method = RequestMethod.GET)
    public Condidat retrieveCondidatById( @RequestParam(name = "condidatId") final Long id) {
        return condidatService.getCondidatById(id).orElse(null);
    }

    // apply for job offer
    @RequestMapping(value = "/applyForJobOffer", method = RequestMethod.POST)
    public void applyForJobOffer(@RequestBody Condidat condidat)
    {
        condidatService.addCondidat(condidat);
    }

    //filter condidats with status
    @RequestMapping(value = "/filterCondidatStatus", method = RequestMethod.GET)
    public List<Condidat> filterCondidatWithStatus(@RequestParam(name = "status") final String status)
    {
        return condidatService.getCondidatByStatus(status);
    }





}
