package tn.narc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import tn.narc.entity.Make;

@EnableMongoRepositories
public interface MakeDaoSpringData extends MongoRepository<Make, String>{
	
	/*public List<VoitureMarque> findByVoitureMarquename(String voitureMarquename);
	public List<VoitureMarque> findAllByVoitureMarquename();
	*/
	List<Make> findByMakeName(String makeName);
	
	

	
	

}
