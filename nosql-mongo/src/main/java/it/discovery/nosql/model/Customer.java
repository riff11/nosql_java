package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "customers")
public class Customer extends BaseEntity {

	private String login;
	
	private String password;
	
	private String name;
	
	private Contact contact;
}
