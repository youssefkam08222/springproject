package tn.narc.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import tn.narc.entity.Voiture;

public interface VoitureDaoSpringData extends MongoRepository<Voiture, String> {
	List<Voiture> findByVoitureId(String voitureId);
	List<Voiture> findByVoitureTypeSerie(String voitureTypeSerie);
	
	
	
}
