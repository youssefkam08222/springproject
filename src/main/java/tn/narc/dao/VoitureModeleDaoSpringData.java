package tn.narc.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import tn.narc.entity.VoitureModele;

public interface VoitureModeleDaoSpringData extends MongoRepository<VoitureModele, String>{
	

}
