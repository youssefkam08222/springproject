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

import tn.narc.entity.CarModel;
import tn.narc.services.CarModelService;

@CrossOrigin("*")
@RestController
@RequestMapping("carmodels")
public class CarModelController {
	@Autowired
	private CarModelService carModelService;
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<CarModel>> getAllCarModel() {
		return ResponseEntity.ok().body(carModelService.getAllCarModel());
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<CarModel> createCarModel(@RequestBody CarModel carModel)
			throws IOException {

		return ResponseEntity.ok().body(this.carModelService.createCarModel(carModel));
	}
	
	

}
