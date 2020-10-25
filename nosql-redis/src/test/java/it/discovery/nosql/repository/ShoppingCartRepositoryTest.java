package it.discovery.nosql.repository;

import it.discovery.nosql.BaseRedisTest;
import it.discovery.nosql.model.ShoppingCart;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartRepositoryTest extends BaseRedisTest {

    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Test
    void save_findById_success() {
        ShoppingCart cart = new ShoppingCart();
        cart.setId("1");
        cart.setBooks(List.of("2", "3"));

        shoppingCartRepository.save(cart);

        ShoppingCart shoppingCart = shoppingCartRepository.findById("1").orElseThrow();
        assertEquals("1", shoppingCart.getId());
        assertEquals(2, shoppingCart.getBooks().size());


    }
}
