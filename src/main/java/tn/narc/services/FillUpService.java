package tn.narc.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.narc.dao.FillUpDaoSpringData;
import tn.narc.dao.VoitureDaoSpringData;
import tn.narc.entity.FillUp;
import tn.narc.entity.Voiture;

@Service
@Transactional
public class FillUpService {

	@Autowired
	private VoitureDaoSpringData voitureDaoSpringData;

	@Autowired
	private FillUpDaoSpringData fillUpDaoSpringData;

	public List<FillUp> createFillUp(FillUp fillUp) throws IOException {

		List<FillUp> fillup = new ArrayList<>();
		fillup.add(fillUpDaoSpringData.save(fillUp));

		return fillup;
	}

	public Voiture getVoitureById(String voitureId) {
		Optional<Voiture> voitureDb = this.voitureDaoSpringData.findById(voitureId);

		if (voitureDb.isPresent()) {
			return voitureDb.get();
		} else {
			throw new RuntimeException("Enregistrement non trouvé avec l'identifiant : " + voitureId);
		}

	}

	public List<FillUp> getAllFillUp() {
		return this.fillUpDaoSpringData.findAll();
	}

	public List<FillUp> finFillUpByVoitureId(String id) {
		List<Voiture> voitureList = this.voitureDaoSpringData.findByVoitureId(id);

		List<FillUp> fillupList = new ArrayList<>();
		for (Voiture v : voitureList) {
			fillupList.addAll(v.getVoitureFillUps());
		}

		return fillupList;
	}

	public FillUp updateFillUp(String voitureid, FillUp fillup) {

		Optional<Voiture> optionalVoiture = this.voitureDaoSpringData.findById(voitureid);

		Optional<FillUp> fillupDb = this.fillUpDaoSpringData.findById(fillup.getFillUpId());

		if (fillupDb.isPresent()) {
			FillUp fillUpUpdate = fillupDb.get();
			fillUpUpdate.setDateFillUp(fillup.getDateFillUp());
			fillUpUpdate.setCostFillUp(fillup.getCostFillUp());
			fillUpUpdate.setFillUpNotes(fillup.getFillUpNotes());
			fillUpUpdate.setImgFillUpName(fillup.getImgFillUpName());
			fillUpUpdate.setImgFillUpUrl(fillup.getImgFillUpUrl());
			fillUpDaoSpringData.save(fillUpUpdate);

			
				Voiture voiture = optionalVoiture.get();
				List<FillUp> fillUps = voiture.getVoitureFillUps();
				for (int i = 0; i < fillUps.size(); i++) {
					if (fillUps.get(i).getFillUpId().equals(fillUpUpdate.getFillUpId())) {
						fillUps.set(i, fillUpUpdate);
						break;
					}
				}
				voiture.setVoitureFillUps(fillUps);
				this.voitureDaoSpringData.save(voiture);
				return fillUpUpdate;
			
		}else {
			throw new RuntimeException("Enregistrement non trouvé avec l'identifiant : " + fillup.getFillUpId());
		}
	}

	public void deleteFillUp(String voitureId, String fillupId) {
		Optional<Voiture> optionalVoiture = this.voitureDaoSpringData.findById(voitureId);
		
		Optional<FillUp> fillupDb = this.fillUpDaoSpringData.findById(fillupId);

		if (fillupDb.isPresent()) {
			
			
			Voiture voiture = optionalVoiture.get();
			FillUp fillUpUpdate = fillupDb.get();
			List<FillUp> fillUps = voiture.getVoitureFillUps();
			for (int i = 0; i < fillUps.size(); i++) {
				if (fillUps.get(i).getFillUpId().equals(fillUpUpdate.getFillUpId())) {
					fillUps.remove(i);
					break;
				}
			}
			voiture.setVoitureFillUps(fillUps);
			this.voitureDaoSpringData.save(voiture);
			this.fillUpDaoSpringData.delete(fillupDb.get());
		} else {
			throw new RuntimeException("Enregistrement non trouvé avec l'identifiant : " + fillupId);
		}
		
	}
}
// off , off all 
// get . to 




