package tn.narc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.narc.dao.CarModelDaoSpringData;
import tn.narc.entity.CarModel;

@Service
@Transactional
public class CarModelService{

	@Autowired
	private CarModelDaoSpringData carModelDaoSpringData; 
	
	public CarModel createCarModel(CarModel carModel) {
		return carModelDaoSpringData.save(carModel);
	}

	public List<CarModel> getAllCarModel() {
		
		return this.carModelDaoSpringData.findAll();
	}
	
	

}
