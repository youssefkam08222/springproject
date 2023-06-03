package tn.narc.entity;

import java.util.List;

import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;

@Data
@Document(collection = "MAKE_COLLECTION")
public class Make {
	
	@Id
	private String id;
	
	@Field(name = "MAKE_NAME")
	@Indexed(unique = true)
	private String makeName;
	
	@ManyToMany
	@DBRef
	private List<MakeYear> makeYears;
	
	

}
