package tn.esprit.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Entity.JobOffre;
import tn.esprit.Repository.JobOffreRepository;

import java.util.List;
import java.util.Optional;

@Service
public class JobOffreService {
	
	  @Autowired
	  private  JobOffreRepository jobOffreRepository;
	  

	  // Create job offre
	  public JobOffre createJobOffre(JobOffre jobOffre){
		 return jobOffreRepository.save(jobOffre);
	  }
	  
	  //delete job offre by 
	  public void deleteJobOffre(Integer joboffreId){
			  jobOffreRepository.deleteById(joboffreId);
		  }


	// get job offres
	public List<JobOffre> retrieveJoboffres(){
		  return jobOffreRepository.findAll();
	}

	public Optional<JobOffre> getJobofferById(Integer id){
		  return jobOffreRepository.findById(id);
	}


	// salary equal
	public List<JobOffre> filterSalaryEqual(Float salary){
		return jobOffreRepository.findBySalaryEquals(salary);
	}

	//greater then salary
	public List<JobOffre> filterGreaterThanSalary(Float salary){
		return jobOffreRepository.findBySalaryIsGreaterThanEqual(salary);
	}

	// less then salary
	public List<JobOffre> filterLessThanSalary(Float salary){
		return jobOffreRepository.findBySalaryLessThan(salary);
	}

	// Filtrage des candidatures
	public void filterCandidat( Long id) {

	}

}
