package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "persons")
@TypeAlias("c")
public class Customer extends Person {

	private String login;

	private String password;

	private List<String> purchasedBooks;
}
