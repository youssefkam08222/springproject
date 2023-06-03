package tn.narc.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("VoituresMarques")

public class VoitureMarque {
	
	@Id
	private String voitureMarqueId;
	
	private String voitureMarquename;
	
	@DBRef
	private List<VoitureModele> voitureModeles; 
	
	public String getVoitureMarqueId() {
		return voitureMarqueId;
	}

	@Override
	public String toString() {
		return "VoitureMarque [voitureMarqueId=" + voitureMarqueId + ", voitureMarquename=" + voitureMarquename
				+ ", voitureModeles=" + voitureModeles + "]";
	}

	public String getVoitureMarquename() {
		return voitureMarquename;
	}

	public void setVoitureMarquename(String voitureMarquename) {
		this.voitureMarquename = voitureMarquename;
	}

	public List<VoitureModele> getVoitureModeles() {
		return voitureModeles;
	}

	public void setVoitureModeles(List<VoitureModele> voitureModeles) {
		this.voitureModeles = voitureModeles;
	}

	public void setVoitureMarqueId(String voitureMarqueId) {
		this.voitureMarqueId = voitureMarqueId;
	}

	public VoitureMarque(String voitureMarqueId, String voitureMarquename, List<VoitureModele> voitureModeles) {
		super();
		this.voitureMarqueId = voitureMarqueId;
		this.voitureMarquename = voitureMarquename;
		this.voitureModeles = voitureModeles;
	}

	public VoitureMarque() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	
	
	
	
	
	
	

}
