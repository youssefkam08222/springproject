package tn.narc.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "CAR_MODEL_COLLECTION")
public class CarModel {
	
	
	@Id
	private String id;
	
	@Field(name = "CAR_MODEL_NAME")
	private String carModelName;
	
	@Field(name = "MAKE_NAME")
	private String makeName;
	
	@Field(name = "MakeYear")
	private Integer yearMake;
		

}
