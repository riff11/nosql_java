package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Base class for all users
 *
 * @author admin
 */
@Getter
@Setter
public class Person extends BaseEntity {
	private String name;

	private Contact contact;
}
