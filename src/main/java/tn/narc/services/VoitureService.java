package tn.narc.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.narc.dao.VoitureDaoSpringData;
import tn.narc.entity.Voiture;

@Service
@Transactional
public class VoitureService {

	@Autowired
	private VoitureDaoSpringData voitureDaoSpringData;

	public Voiture createVoiture(Voiture voiture) throws IOException {

		return voitureDaoSpringData.save(voiture);
	}

	public Voiture updateVoiture(Voiture voiture) {
		Optional<Voiture> voitureDb = this.voitureDaoSpringData.findById(voiture.getVoitureId());

		if (voitureDb.isPresent()) {
			Voiture voitureUpdate = voitureDb.get();
			voitureUpdate.setVoitureId(voiture.getVoitureId());
			voitureUpdate.setImgVoitureUrl(voiture.getImgVoitureUrl());
			voitureUpdate.setVoitureMake(voiture.getVoitureMake());
			voitureUpdate.setVoitureMakeYear(voiture.getVoitureMakeYear());
			voitureUpdate.setVoitureModele(voiture.getVoitureModele());
			voitureUpdate.setVoitureTypeSerie(voiture.getVoitureTypeSerie());
			voitureUpdate.setVoitureSerie(voiture.getVoitureSerie());
			voitureUpdate.setVoitureCarburant(voiture.getVoitureCarburant());
			voitureUpdate.setVoitureKilometrage(voiture.getVoitureKilometrage());
			voitureUpdate.setVoitureNotes(voiture.getVoitureNotes());
			voitureUpdate.setImgFaceCarteGriseUrl(voiture.getImgFaceCarteGriseUrl());
			voitureUpdate.setImgDosCarteGriseUrl(voiture.getImgDosCarteGriseUrl());
			voitureUpdate.setImgAssuranceUrl(voiture.getImgAssuranceUrl());
			voitureUpdate.setImgTaxUrl(voiture.getImgTaxUrl());
			voitureUpdate.setImgVisiteUrl(voiture.getImgVisiteUrl());
			voitureDaoSpringData.save(voitureUpdate);
			return voitureUpdate;
		} else {
			throw new RuntimeException("Enregistrement non trouvé avec l'identifiant : " + voiture.getVoitureId());
		}

	}

	public List<Voiture> getAllVoiture() {
		System.out.println(voitureDaoSpringData.findAll());
		return this.voitureDaoSpringData.findAll();
	}

	public Voiture getVoitureById(String voitureId) {
		Optional<Voiture> voitureDb = this.voitureDaoSpringData.findById(voitureId);

		if (voitureDb.isPresent()) {
			return voitureDb.get();
		} else {
			throw new RuntimeException("Enregistrement non trouvé avec l'identifiant : " + voitureId);
		}

	}

	public void deleteVoiture(String voitureId) {
		Optional<Voiture> voitureDb = this.voitureDaoSpringData.findById(voitureId);

		if (voitureDb.isPresent()) {
			this.voitureDaoSpringData.delete(voitureDb.get());
		} else {
			throw new RuntimeException("Enregistrement non trouvé avec l'identifiant : " + voitureId);
		}

	}

	public Boolean verifyVoitureSerieExists(String voitureTypeSerie,String voitureSerie) {
		
		List<Voiture> voitureList = this.voitureDaoSpringData.findByVoitureTypeSerie(voitureTypeSerie);
		Boolean exist = false;
		for (Voiture v : voitureList) {
			if (v.getVoitureSerie().equals(voitureSerie.toString())) {
				exist = true;
				break;
			}
		}
		return exist;
	}

}
