package tn.narc.entity;

import java.util.List;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "MAKE_YEAR_COLLECTION")
public class MakeYear {
	
	@Id
	private String id;
	
	@Field(name = "MAKE_YEAR")
	private Integer yearMake;
	

	@DBRef
	private List<CarModel> carModels;
	
	

}
