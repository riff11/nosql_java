package it.discovery.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table
@Entity
@Getter
@Setter
public class Customer extends BaseEntity {

	private String login;
	
	private String password;
	
	private String name;
	
	@Embedded
	private Contact contact;
}
