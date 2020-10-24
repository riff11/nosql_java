package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
	private String country;

	private String city;

	private String street;

	private String apt;
}
