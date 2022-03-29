package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Condidat;
import tn.esprit.Entity.JobOffre;

import tn.esprit.Repository.CondidatRepository;
import tn.esprit.Repository.JobOffreRepository;
import tn.esprit.Service.JobOffreService;

import java.util.List;

@RestController
public class JobOffreController {
	
	 @Autowired
	 private JobOffreService jobOffreService;

	@Autowired
	private JobOffreRepository jobOffreRepository;

	@Autowired
	private CondidatRepository condidatRepository;

	 // create
	  @PostMapping(value = "/CreateJoboffre")
	  //@RequestMapping(value = "/CreateJoboffre", method = RequestMethod.POST)
	  public JobOffre saveJoboffre(@RequestBody JobOffre jobOffre) {
	    return jobOffreService.createJobOffre(jobOffre);
	  }

	  //delete
	  @RequestMapping(value = "/deleteJoboffre", method = RequestMethod.DELETE)
	  public void deleteJoboffre(@RequestParam(name = "jobOffreId") final Integer id) {
	     jobOffreService.deleteJobOffre(id);
	  }

	  //update
	@RequestMapping(value = "/updateJoboffre", method = RequestMethod.PUT)
	JobOffre replaceJobOffre(@RequestBody JobOffre newJoboffre, @RequestParam(name = "jobOffreId") final Integer id) {

		return jobOffreRepository.findById(id)
				.map(jobOffre -> {
					jobOffre.setTitleOffre(newJoboffre.getTitleOffre());
					jobOffre.setSalary(newJoboffre.getSalary());
					jobOffre.setOffreDescription(newJoboffre.getOffreDescription());
					return jobOffreRepository.save(jobOffre);
				})
				.orElseGet(() -> {
					return jobOffreRepository.save(newJoboffre);
				});
	}

	//get job offres
	@RequestMapping(value = "/jobOffers", method = RequestMethod.GET)
	public List<JobOffre> retrieveJobOffers() {
		return jobOffreService.retrieveJoboffres();
	}

	//get job offre by id
	@RequestMapping(value = "/jobOffer", method = RequestMethod.GET)
	public JobOffre retrieveJobOfferById( @RequestParam(name = "jobOffreId") final Integer id) {
		return jobOffreService.getJobofferById(id).orElse(null);
	}

	//filter salary
	@RequestMapping(value = "/jobOfferBySalaryEqual", method = RequestMethod.GET)
	public List<JobOffre> retrieveJobOfferBySalaryEqual(@RequestParam(name = "salary") final Float salary) {
		return jobOffreService.filterSalaryEqual(salary);
	}

	//filter greater salary
	@RequestMapping(value = "/jobOfferBySalaryGreater", method = RequestMethod.GET)
	public List<JobOffre> retrieveJobOfferBySalaryGreater(@RequestParam(name = "salary") final Float salary) {
		return jobOffreService.filterGreaterThanSalary(salary);
	}

	//filter less salary
	@RequestMapping(value = "/jobOfferBySalaryLess", method = RequestMethod.GET)
	public List<JobOffre> retrieveJobOfferBySalaryLess(@RequestParam(name = "salary") final Float salary) {
		return jobOffreService.filterLessThanSalary(salary);
	}

	// Filtrage des candidatures
	@RequestMapping(value = "/filterCondidat", method = RequestMethod.PUT)
	public Condidat updateCondidat(
			@RequestParam(name = "idCondidat") final Long idCondidat,
			@RequestParam(name = "status") final String status) {

		  Condidat con = condidatRepository.findById(idCondidat).orElse(null);
		assert con != null;
		con.setStatus(status);
		  return condidatRepository.save(con);
	}


}
