package it.discovery.hibernate.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table
@Entity
@Getter
@Setter
public class Hit extends BaseEntity {

	private String ip;
	
	private String browser;
	
	/**
	 * Details on how(where) user hit this link
	 */
	private String origin;
	
	private boolean mobile;

	@ManyToOne(optional = false)
	@JoinColumn(name = "book_id")
	private Book book;
}
