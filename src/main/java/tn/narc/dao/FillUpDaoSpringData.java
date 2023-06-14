package tn.narc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import tn.narc.entity.FillUp;

public interface FillUpDaoSpringData extends MongoRepository<FillUp, String> {
	List<FillUp> findByDateFillUp(String dateFillUp);
	
	
}
