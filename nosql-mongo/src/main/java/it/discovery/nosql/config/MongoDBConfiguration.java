package it.discovery.nosql.config;

import it.discovery.nosql.model.Book;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.index.Index;

@Configuration
public class MongoDBConfiguration {

    @Bean
    public ApplicationListener<ApplicationReadyEvent> checkIndexes(MongoOperations mongoOperations) {
        return event ->
                mongoOperations.indexOps(Book.class)
                        .ensureIndex(new Index().on("translations.$**", Sort.Direction.ASC));
    }

}
