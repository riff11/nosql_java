package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contact {
	private String phone;

	private String email;
	
	private Address address;
}
