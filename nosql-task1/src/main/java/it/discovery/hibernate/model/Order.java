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
public class Order extends BaseEntity {
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "book_id")	
	private Book book;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "customer_id")	
	private Customer customer;
	
	private int amount;

}
