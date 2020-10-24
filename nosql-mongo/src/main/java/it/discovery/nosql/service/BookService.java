package it.discovery.nosql.service;

import it.discovery.nosql.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;

@RequiredArgsConstructor
public class BookService {

    private final MongoTemplate mongoTemplate;

    public List<Book> findByName(String name) {
        return mongoTemplate.find(new Query(Criteria.where("translations.text").is(name)), Book.class);
    }

    public void saveBook(Book book) {
        mongoTemplate.save(book);
    }
}
