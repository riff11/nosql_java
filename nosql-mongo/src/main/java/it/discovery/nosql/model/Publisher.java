package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Book publisher
 */
@Getter
@Setter
@Document(collection = "publishers")
public class Publisher extends BaseEntity {
	private String name;

	private List<String> books;

	private Contact contact;
}
