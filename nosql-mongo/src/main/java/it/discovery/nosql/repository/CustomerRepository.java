package it.discovery.nosql.repository;

import it.discovery.nosql.model.Customer;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    @Override
    default List<Customer> findAll() {
        Customer probe = new Customer();
        return findAll(Example.of(probe));
    }
}
