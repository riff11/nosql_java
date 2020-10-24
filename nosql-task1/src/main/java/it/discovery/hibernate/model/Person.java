package it.discovery.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Book authors
 * 
 * @author admin
 *
 */
@Table
@Entity
@Getter
@Setter
public class Person extends BaseEntity {
	private String name;

	/**
	 * Books that person has written
	 */
	@OneToMany(mappedBy = "author")
	private List<Book> books;

	@Embedded
	private Contact contact;
}
