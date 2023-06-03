package tn.narc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document("Voitures")
public class Voiture {

	@Id
	private String voitureId;
	private String imgVoitureUrl;
	private String voitureMake;
	private String voitureMakeYear;
	private String voitureModele;
	private String voitureTypeSerie;
	private String voitureSerie;
	private String voitureCarburant;
	private int voitureKilometrage;
	private String voitureNotes;
	private String imgFaceCarteGriseUrl;
	private String imgDosCarteGriseUrl;
	private String imgAssuranceUrl;
	private String imgTaxUrl;
	private String imgVisiteUrl;

	

	public Voiture() {
		super();

	}



	public Voiture(String voitureId, String imgVoitureUrl, String voitureMake, String voitureMakeYear,
			String voitureModele, String voitureTypeSerie, String voitureSerie, String voitureCarburant,
			int voitureKilometrage, String voitureNotes, String imgFaceCarteGriseUrl, String imgDosCarteGriseUrl,
			String imgAssuranceUrl, String imgTaxUrl, String imgVisiteUrl) {
		super();
		this.voitureId = voitureId;
		this.imgVoitureUrl = imgVoitureUrl;
		this.voitureMake = voitureMake;
		this.voitureMakeYear = voitureMakeYear;
		this.voitureModele = voitureModele;
		this.voitureTypeSerie = voitureTypeSerie;
		this.voitureSerie = voitureSerie;
		this.voitureCarburant = voitureCarburant;
		this.voitureKilometrage = voitureKilometrage;
		this.voitureNotes = voitureNotes;
		this.imgFaceCarteGriseUrl = imgFaceCarteGriseUrl;
		this.imgDosCarteGriseUrl = imgDosCarteGriseUrl;
		this.imgAssuranceUrl = imgAssuranceUrl;
		this.imgTaxUrl = imgTaxUrl;
		this.imgVisiteUrl = imgVisiteUrl;
	}

}
