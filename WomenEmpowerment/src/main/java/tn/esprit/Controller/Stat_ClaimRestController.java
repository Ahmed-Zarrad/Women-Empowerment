package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.Entity.Stat_Claim;
import tn.esprit.Service.Stat_ClaimService;

@RestController
@RequestMapping("/Stat_Claim")
public class Stat_ClaimRestController {

	@Autowired
	Stat_ClaimService stat_claimService;

	// http://localhost:8090/Stat_Claim
		@GetMapping
		public List<Stat_Claim> statistique(){
			return stat_claimService.statistique();
		}
		
		
		
}
