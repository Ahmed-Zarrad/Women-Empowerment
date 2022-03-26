package tn.esprit.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.Service.ClaimService;
import tn.esprit.Entity.Claim;

@RestController
@RequestMapping("/Claim")
public class ClaimRestController {

	@Autowired
	private ClaimService ClaimService ;
	
	
	// http://localhost:8090/Claim/retrieveAllClaims
	@GetMapping("/retrieveAllClaims")
	@ResponseBody
	public List<Claim> retrieveAllClaims(){
		return ClaimService.retrieveAllClaims();
	}
	
	
	// http://localhost:8090/Claim/retrieveClaimById/{idClaim}
	@GetMapping("/retrieveClaimById/{idClaim}")
	@ResponseBody
	public Claim retrieveClaimById(@PathVariable("idClaim") Integer  id){
		return ClaimService.retrieveClaim(id);
	}
	
	
	// http://localhost:8090/Claim/addClaim
	@PostMapping("/addClaim")
	public Claim addClaim(@RequestBody Claim c){
		return ClaimService.addClaim(c);
	}
	// http://localhost:8090/Claim/addClaimCat

	@PostMapping("/addClaimCat")
	public Claim addClaimCat(@RequestBody Claim c){
		return ClaimService.addClaimWithCategory(c);
	}
	// http://localhost:8090/Claim/updateClaim
	@PutMapping("/updateClaim")
	@ResponseBody
	public Claim updateClaim(@RequestBody Claim c){
		
		return ClaimService.updateClaim(c);
	}
	
	
	// http://localhost:8090/Claim/removeClaim/{Claim-id}

	@DeleteMapping("/removeClaim/{Claim-id}")
	@ResponseBody
	public void removeClaim(@PathVariable("Claim-id") Integer ClaimId) {
		ClaimService.deleteClaim(ClaimId);
	}
	
	
	
}
