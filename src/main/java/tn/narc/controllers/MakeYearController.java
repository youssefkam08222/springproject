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

import tn.narc.entity.CarModel;
import tn.narc.entity.MakeYear;
import tn.narc.services.MakeYearService;

@CrossOrigin("*")
@RestController
@RequestMapping("makeyear")
public class MakeYearController {
	@Autowired
	private MakeYearService makeYearService;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<MakeYear>> getAllMakeYear() {
		return ResponseEntity.ok().body(makeYearService.getAllMakeYear());
	}
	
	@PostMapping("/create")
	public ResponseEntity<MakeYear> createVoitureModel(@RequestBody MakeYear makeYear)
			throws IOException {

		return ResponseEntity.ok().body(this.makeYearService.createMakeYear(makeYear));
	}
	
	@GetMapping("/allcarmodelsbymakeyear/{yearMake}")
	public ResponseEntity<List<CarModel>> getAllCarModelsByMakeYear(@PathVariable Integer yearMake) {

			return ResponseEntity.ok().body(makeYearService.findCarModelsByMakeYear(yearMake));
	}
	
	

}
