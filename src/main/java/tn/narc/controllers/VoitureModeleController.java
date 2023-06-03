package tn.narc.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.narc.entity.VoitureModele;
import tn.narc.services.VoitureModeleService;

@CrossOrigin("*")
@RestController
@RequestMapping("voituresmodeles")
public class VoitureModeleController {
	@Autowired
	private VoitureModeleService voitureModeleService;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<VoitureModele>> getAllVoitureModele() {
		return ResponseEntity.ok().body(voitureModeleService.getAllVoitureModele());
	}
	
	@PostMapping("/create")
	public ResponseEntity<VoitureModele> createVoitureModel(@RequestBody VoitureModele voitureModele)
			throws IOException {

		return ResponseEntity.ok().body(this.voitureModeleService.createVoitureModele(voitureModele));
	}
	
	

}
