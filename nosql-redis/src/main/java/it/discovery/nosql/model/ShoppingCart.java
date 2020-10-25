package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RedisHash(value = "cart", timeToLive = 30)
public class ShoppingCart {
    @Id
    private String id;

    private List<String> books;

    @CreatedDate
    private LocalDateTime createdAt;
}
