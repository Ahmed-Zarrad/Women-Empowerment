package tn.esprit.Controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entity.Membership;
import tn.esprit.Service.MembershipService;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin("*")
@RequestMapping("/membership")

public class MembershipController {

	private MembershipService membershipService;
	@PostMapping("/addMembership")

	Membership addMembership(@RequestBody Membership membership){
		return membershipService.addMembership(membership);
	}

	@GetMapping("/getMembership/{idMem}")

	Membership getMembershipById(@PathVariable("idMem") Long idMem){
		return membershipService.getMembershipById(idMem);
	}

	/*@GetMapping("/get-Memberships/{idUser}")

	List <Membership> listedeMemberships(@PathVariable("idUser") Long idUser){
		return membershipService.listedeMemberships(idUser);
	}*/
	@DeleteMapping("/delete-membership/{idMem}")
	void deleteMembership (@PathVariable("idMem") Long idMem){
		membershipService.deleteMembership(idMem);
	}

	@GetMapping("/get-All-Memberships")

	List<Membership>  getAllMembership(){
		return 	membershipService.getMemberships();
	}

	/*@PostMapping("/ajouterMembership/{idUser}")

	void ajouterETaffecterListemembership(@RequestBody List<Membership> lb,@PathVariable("idUser") Long idUser){
		 membershipService.ajouterETaffecterListemembership( lb,  idUser);
	}*/
	@PutMapping ("/updateCentre")
	Membership updateMembership(@RequestBody Membership membership){
		return membershipService.updateMembership(membership);
	}

}
