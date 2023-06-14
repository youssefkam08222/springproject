package tn.narc.entity;

import java.util.List;

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
	private List<FillUp> voitureFillUps;
}
