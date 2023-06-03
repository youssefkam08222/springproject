package tn.narc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import tn.narc.entity.CarModel;

public interface CarModelDaoSpringData extends MongoRepository<CarModel, String>{
	

}
