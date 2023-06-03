package tn.narc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import tn.narc.entity.VoitureMarque;

@EnableMongoRepositories
public interface VoitureMarqueDaoSpringData extends MongoRepository<VoitureMarque, String>{
	
	/*public List<VoitureMarque> findByVoitureMarquename(String voitureMarquename);
	public List<VoitureMarque> findAllByVoitureMarquename();
	*/
	List<VoitureMarque> findByVoitureMarquename(String voitureMarquename);
	List<VoitureMarque> findByVoitureMarqueId(String voitureMarqueId);
	
	
	

}
