package tn.narc.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.narc.dao.VoitureModeleDaoSpringData;
import tn.narc.entity.VoitureModele;

@Service
@Transactional
public class VoitureModeleService{

	@Autowired
	private VoitureModeleDaoSpringData voitureModeleDaoSpringData; 
	
	public VoitureModele createVoitureModele(VoitureModele voitureModele) {
		return voitureModeleDaoSpringData.save(voitureModele);
	}

	public List<VoitureModele> getAllVoitureModele() {
		
		return this.voitureModeleDaoSpringData.findAll();
	}
	
	

}
