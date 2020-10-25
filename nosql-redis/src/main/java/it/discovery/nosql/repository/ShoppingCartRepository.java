package it.discovery.nosql.repository;

import it.discovery.nosql.model.ShoppingCart;
import org.springframework.data.keyvalue.repository.KeyValueRepository;

public interface ShoppingCartRepository extends KeyValueRepository<ShoppingCart, String> {
}
