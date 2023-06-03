package tn.narc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import tn.narc.entity.MakeYear;

public interface MakeYearDaoSpringData extends MongoRepository<MakeYear, String>{
	
	List<MakeYear> findByYearMake(Integer yearMake);

}
