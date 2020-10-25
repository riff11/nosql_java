package it.discovery.nosql;

import it.discovery.nosql.callback.AuditCallback;
import it.discovery.nosql.service.BookService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
@EnableMongoAuditing
public class MongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);
    }

    @Bean
    public BookService bookService(MongoTemplate mongoTemplate) {
        return new BookService(mongoTemplate);
    }

    @Bean
    public AuditCallback auditCallback() {
        return new AuditCallback();
    }
}
