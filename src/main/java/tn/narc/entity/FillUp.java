package tn.narc.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Fill_Up_COLLECTION")
public class FillUp {

	@Id
	private String fillUpId;
	private String dateFillUp;
	private int costFillUp;
	private String imgFillUpName;
	private String imgFillUpUrl;
	private String fillUpNotes;

}
