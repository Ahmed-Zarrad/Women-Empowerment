package tn.esprit.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Claim;
import tn.esprit.Service.ClaimService;

import java.util.List;

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
