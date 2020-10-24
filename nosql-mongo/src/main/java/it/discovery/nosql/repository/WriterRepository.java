package it.discovery.nosql.repository;

import it.discovery.nosql.model.Writer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface WriterRepository extends MongoRepository<Writer, String> {

	/**
	 * Returns all the persons sorted by name
	 *
	 * @return
	 */
	List<Writer> findByOrderByNameAsc();
}
