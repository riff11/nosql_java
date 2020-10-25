package it.discovery.nosql.callback;

import it.discovery.nosql.model.AuditLog;
import it.discovery.nosql.model.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveCallback;

@RequiredArgsConstructor
public class AuditCallback implements AfterSaveCallback<BaseEntity> {

    @Autowired
    private ApplicationContext context;

    private MongoOperations mongoOperations;

    @Override
    public BaseEntity onAfterSave(BaseEntity entity, Document document, String collection) {

        AuditLog auditLog = new AuditLog();
        auditLog.setEntityId(entity.getId());
        auditLog.setAlias(entity.getClass().getName());
        auditLog.setState(entity);

        getMongoTemplate().save(auditLog);
        return entity;
    }

    //TODO add synchronization
    private MongoOperations getMongoTemplate() {
        if (mongoOperations == null) {
            mongoOperations = context.getBean(MongoOperations.class);
        }
        return mongoOperations;
    }
}
