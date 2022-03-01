package tn.esprit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.Entity.Participant;

import tn.esprit.services.IParticipantService;

@RestController
public class RestControlParticipant {

	
	@Autowired
	IParticipantService iparticipantservice;

	
	// http://localhost:8085/SpringMVC/servlet/ajouterParticipant

	@PostMapping("/ajouterParticipant")
	@ResponseBody
	public Participant ajouterParticipant(@RequestBody Participant participant)
	{
		iparticipantservice.ajouterParticipant(participant);
		return participant;
	}
	
	
	 // URL : http://localhost:8085/SpringMVC/servlet/get
	@GetMapping(value ="/get")
    @ResponseBody
	public List<Participant> getAllParticipant() {
		
		return iparticipantservice.getAllParticipant();
		
	}

	// URL : http://localhost:8085/SpringMVC/servlet/deleteParticipantById/1
    @DeleteMapping("/deleteParticipantById/{idparticipant}") 
    @ResponseBody
	public void deleteParticipantById(@PathVariable("idparticipant") int participantId) {
		iparticipantservice.deleteParticipantById(participantId);
	
	
    }}
