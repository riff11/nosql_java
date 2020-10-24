package it.discovery.nosql.repository;

import it.discovery.nosql.BaseMongoTest;
import it.discovery.nosql.model.Customer;
import it.discovery.nosql.model.Writer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CustomerRepositoryTest extends BaseMongoTest {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Test
    void saveCustomer_returnsCustomer() {
        Customer customer = new Customer();
        customer.setName("John");
        customerRepository.save(customer);

        Writer writer = new Writer();
        writer.setName("Robert Marting");
        mongoTemplate.save(writer);

        List<Customer> customers = customerRepository.findAll();
        assertEquals(1, customers.size());
        assertEquals("John", customer.getName());
    }


}
