package it.discovery.nosql.callback;

import it.discovery.nosql.BaseMongoTest;
import it.discovery.nosql.model.AuditLog;
import it.discovery.nosql.model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuditCallbackTest extends BaseMongoTest {

    @Autowired
    MongoOperations mongoOperations;

    @Test
    void saveBook_auditGenerated() {
        Book book = new Book();
        book.addTranslation("Callback", "en_US");

        mongoOperations.save(book);

        List<AuditLog> logs = mongoOperations.findAll(AuditLog.class);
        assertEquals(1, logs.size());
        assertEquals(book.getId(), logs.get(0).getEntityId());
        assertEquals(Book.class.getName(), logs.get(0).getAlias());
        assertNotNull(logs.get(0).getState());
    }
}
