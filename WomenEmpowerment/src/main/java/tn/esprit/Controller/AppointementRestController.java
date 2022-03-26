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
import tn.esprit.Entity.Appointement;
import tn.esprit.Service.AppointementService;


@RestController
@RequestMapping("/Appointement")
public class AppointementRestController {
	
	@Autowired
	 AppointementService appointementservice ;
	
	
	// http://localhost:8090/Appointement/retrieveAllAppointements
	@GetMapping("/retrieveAllAppointements")
	@ResponseBody
	public List<Appointement> retrieveAllAppointements(){
		return appointementservice.retrieveAllAppointements();
	}
	
	
	// http://localhost:8090/Appointement/retrieveAppointementById/{idAppointement}
	@GetMapping("/retrieveAppointementById/{idAppointement}")
	@ResponseBody
	public Appointement retrieveAppointementById(@PathVariable("idAppointement") Integer  id){
		return appointementservice.retrieveAppointement(id);
	}
	
	
	// http://localhost:8090/Appointement/addAppointement
	@PostMapping("/addAppointement")
	public Appointement addAppointement(@RequestBody Appointement A){
		return appointementservice.addAppointement(A);
	}
	
	
	// http://localhost:8090/Appointement/updateAppointement
	@PutMapping("/updateAppointement")
	@ResponseBody
	public Appointement updateAppointement(@RequestBody Appointement A){
		
		return appointementservice.updateAppointement(A);
	}
	
	
	// http://localhost:8090/Appointement/removeAppointement/{Appointement-id}

	@DeleteMapping("/removeAppointement/{Appointement-id}")
	@ResponseBody
	public void removeAppointement(@PathVariable("Appointement-id") Integer AppointementId) {
		appointementservice.deleteAppointement(AppointementId);
	}
	
	
	
}

