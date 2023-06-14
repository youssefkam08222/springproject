package tn.narc.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.narc.entity.FillUp;
import tn.narc.entity.Voiture;
import tn.narc.services.FillUpService;
import tn.narc.services.VoitureService;

@CrossOrigin("*")
@RestController
@RequestMapping("fillup")
public class FillUpController {

	@Autowired
	private VoitureService voitureService;

	@Autowired
	private FillUpService fillUpService;

	@GetMapping("/all")
	public ResponseEntity<List<FillUp>> getAllFillUp() {

		return ResponseEntity.ok().body(fillUpService.getAllFillUp());
	}

	@PostMapping("/create/{voitureid}")
	public ResponseEntity<Voiture> finFillUpByVoitureId(@PathVariable String voitureid, @RequestBody FillUp fillUp)
			throws IOException {

		Voiture voiture = voitureService.addVoitureFillUp(voitureid, fillUpService.createFillUp(fillUp));

		return ResponseEntity.ok().body(voiture);
	}

	@GetMapping("getfillupbyvoitureid/{id}")
	public ResponseEntity<List<FillUp>> getFillUpByVoitureId(@PathVariable String id) {
		return ResponseEntity.ok().body(fillUpService.finFillUpByVoitureId(id));
	}

	@PutMapping("/update/{voitureid}")
	public ResponseEntity<FillUp> updateVoiture(@PathVariable String voitureid, @RequestBody FillUp fillup) {
		return ResponseEntity.ok().body(this.fillUpService.updateFillUp(voitureid,fillup));
	}
	
	@DeleteMapping("/delete/{voitureid}/{fillupid}")
	public ResponseEntity<HttpStatus> deleteVoiture(@PathVariable String voitureid,@PathVariable String fillupid) {
		fillUpService.deleteFillUp(voitureid,fillupid);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	

}
