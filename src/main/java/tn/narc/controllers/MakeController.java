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

import tn.narc.entity.Make;
import tn.narc.services.MakeService;

@CrossOrigin("*")
@RestController
@RequestMapping("make")
public class MakeController {
	@Autowired
	private MakeService makeService;

	@PostMapping("/create")
	public ResponseEntity<Make> createMake(@RequestBody Make make) throws IOException {

		return ResponseEntity.ok().body(this.makeService.createMake(make));
	}

	@GetMapping("/all")
	public ResponseEntity<List<String>> getAllMake() {

		return ResponseEntity.ok().body(makeService.getAllMake());
	}

	@GetMapping("/allmakeyearbymakename/{makeName}")
	public ResponseEntity<List<String>> getAllMakeYearByMarque(@PathVariable String makeName) {

		return ResponseEntity.ok().body(makeService.findMakeYearsByMakeName(makeName));
	}

	@GetMapping("/allcarmodelbymakeyearandmakename/{makeName}/{makeYear}")
	public ResponseEntity<List<String>> findCarModelByMakeNameAndMakeYear(@PathVariable String makeName,
			@PathVariable String makeYear) {

		return ResponseEntity.ok().body(makeService.findCarModelByMakeNameAndMakeYear(makeName, makeYear));
	}

}
