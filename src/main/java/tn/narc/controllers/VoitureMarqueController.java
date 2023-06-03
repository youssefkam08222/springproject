package tn.narc.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.narc.entity.VoitureMarque;
import tn.narc.entity.VoitureModele;
import tn.narc.services.VoitureMarqueService;

@CrossOrigin("*")
@RestController
@RequestMapping("voituresmarques")
public class VoitureMarqueController {
	@Autowired
	private VoitureMarqueService voitureMarqueService;
	
	@GetMapping("/all")
	public ResponseEntity<List<VoitureMarque>> getAllVoitureMarque() {

		
		
		return ResponseEntity.ok().body(voitureMarqueService.getAllVoitureMarque());
	}
	
	@GetMapping("/allmodelesbymarque/{marque}")
	public ResponseEntity<List<VoitureModele>> getAllVoitureByMarque(@PathVariable String marque) {

			return ResponseEntity.ok().body(voitureMarqueService.findByVoitureModelesByMarqueName(marque));
	}
	
	@PostMapping("/create")
	public ResponseEntity<VoitureMarque> createVoitureMarque(@RequestBody VoitureMarque voitureMarque)
			throws IOException {

		return ResponseEntity.ok().body(this.voitureMarqueService.createVoitureMarque(voitureMarque));
	}

}
