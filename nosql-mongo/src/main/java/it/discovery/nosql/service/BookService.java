package it.discovery.nosql.service;

import it.discovery.nosql.model.Book;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
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

    /**
     * Returns overall number of pages for all the books
     *
     * @return
     */
    public Integer findTotalPages() {
        GroupOperation sumOp = Aggregation.group()
                .sum("pages").as("totalPages");
        Aggregation pipeline = Aggregation.newAggregation(sumOp);
        Document result = mongoTemplate.aggregate(pipeline, "books", Document.class)
                .getUniqueMappedResult();
        return result.getInteger("totalPages");
    }
}
