package tn.narc.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.narc.dao.VoitureMarqueDaoSpringData;
import tn.narc.entity.VoitureMarque;
import tn.narc.entity.VoitureModele;

@Service
@Transactional
public class VoitureMarqueService{

	@Autowired
	private VoitureMarqueDaoSpringData voitureMarqueDaoSpringData;
	
	
	private String id;


	private List<VoitureModele> vm; 
	
	public VoitureMarque createVoitureMarque(VoitureMarque voitureMarque) {
		return voitureMarqueDaoSpringData.save(voitureMarque);
	}

	public List<VoitureMarque> getAllVoitureMarque() {
		
		return this.voitureMarqueDaoSpringData.findAll();
	}

	public List<VoitureModele> findByVoitureModelesByMarqueName(String voitureMarquename) {
			
		List<VoitureMarque> voitureMarque = voitureMarqueDaoSpringData.findByVoitureMarquename(voitureMarquename);
		VoitureMarque v= new VoitureMarque();
		
		int count=0;
		
		 while (voitureMarque.size() > count) {
			 v = voitureMarque.get(count);
		         count++;
		         if(v.getVoitureMarquename().toString().equals(voitureMarquename) ) {
						this.id = v.getVoitureMarqueId().toString();
						count = voitureMarque.size();
					}
		      }
		 Optional<VoitureMarque> voitureOptional =  voitureMarqueDaoSpringData.findById(id); 
		 VoitureMarque voituremarque = voitureOptional.get();
		 vm = voituremarque.getVoitureModeles();
		  
		return this.vm;
	}



	


	


}
