package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@Document(collection = "persons")
@TypeAlias("w")
public class Writer extends Person {
    /**
     * Books that person has written
     */
    private List<String> works;
}
