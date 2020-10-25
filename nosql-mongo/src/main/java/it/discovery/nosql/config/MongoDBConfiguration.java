package it.discovery.nosql.config;

import it.discovery.nosql.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.Index;

import javax.annotation.PostConstruct;

@Configuration
public class MongoDBConfiguration {

    @Autowired
    private MongoOperations mongoOperations;

    @PostConstruct
    public void checkIndexes() {
        mongoOperations.indexOps(Book.class)
                .ensureIndex(new Index().on("translations.text", Sort.Direction.ASC));

    }
}
