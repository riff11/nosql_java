package it.discovery.nosql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Setter
@Document(collection = "audit")
public class AuditLog {

    @Id
    private String id;

    private String entityId;

    private String alias;

    @CreatedDate
    private LocalDateTime createdAt;

    private BaseEntity state;
}
