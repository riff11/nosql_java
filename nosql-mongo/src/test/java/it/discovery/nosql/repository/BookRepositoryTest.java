package it.discovery.nosql.repository;

import it.discovery.nosql.BaseMongoTest;
import it.discovery.nosql.model.Book;
import it.discovery.nosql.model.Person;
import it.discovery.nosql.model.Publisher;
import it.discovery.nosql.model.Review;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookRepositoryTest extends BaseMongoTest {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    PersonRepository personRepository;

    @Test
    @Disabled
    void findWithReviews_returnsSingleBook() {
        Person author = new Person();
        author.setName("Gavin King");

        personRepository.save(author);
        Publisher publisher = new Publisher();
        publisher.setName("Packt");

        Book book1 = new Book();
        book1.addTranslation("JPA", "en_US");
        book1.setAuthorId(author.getId());
        //book1.setPublisherId(null);

        Book book2 = new Book();
        book1.addTranslation("Hibernate", "en_US");
        book2.setAuthorId(author.getId());
        //book2.setPublisher(null);

        Review review = new Review();
        review.setComment("good");
        review.setRate(10);
        book2.addReview(review);
        bookRepository.saveAll(List.of(book1, book2));

//        List<Book> books = bookRepository.findWithReviews();
//        assertEquals(1, books.size());
//        assertEquals("Hibernate", books.get(0).getTranslations().get(0).getText());
    }

    @Test
    void saveWithTranslaction_findAll_returnsSingleBook() {
        Person author = new Person();
        author.setName("Gavin King");

        personRepository.save(author);
        Publisher publisher = new Publisher();
        publisher.setName("Packt");

        Book book1 = new Book();
        book1.addTranslation("JPA", "en_US");
        book1.setAuthorId(author.getId());
        bookRepository.save(book1);

        List<Book> books = bookRepository.findAll();
        assertEquals(1, books.size());
        assertEquals("JPA", books.get(0).getTranslations().get(0).getText());
    }

}
