package tn.narc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("VoituresModeles")
public class VoitureModele {
	
	@Id
	private String voitureModeleId;
	private String voitureModelename;
	
	
	@Override
	public String toString() {
		return "VoitureModele [voitureModeleId=" + voitureModeleId + ", voitureModelename=" + voitureModelename + "]";
	}
	public VoitureModele(String voitureModeleId, String voitureModelename) {
		super();
		this.voitureModeleId = voitureModeleId;
		this.voitureModelename = voitureModelename;
	}
	public String getVoitureModeleId() {
		return voitureModeleId;
	}
	public void setVoitureModeleId(String voitureModeleId) {
		this.voitureModeleId = voitureModeleId;
	}
	public String getVoitureModelename() {
		return voitureModelename;
	}
	public void setVoitureModelename(String voitureModelename) {
		this.voitureModelename = voitureModelename;
	}
	public VoitureModele() {
		super();
		// TODO Auto-generated constructor stub
	}

	




}
