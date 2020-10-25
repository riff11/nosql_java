package it.discovery.nosql.callback;

import it.discovery.nosql.model.AuditLog;
import it.discovery.nosql.model.BaseEntity;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.mapping.event.AfterSaveCallback;

@RequiredArgsConstructor
public class AuditCallback implements AfterSaveCallback<BaseEntity> {
    private final MongoOperations mongoOperations;

    @Override
    public BaseEntity onAfterSave(BaseEntity entity, Document document, String collection) {

        AuditLog auditLog = new AuditLog();
        auditLog.setId(entity.getId());
        auditLog.setAlias(entity.getClass().getName());
        auditLog.setState(entity);

        mongoOperations.save(auditLog);
        return entity;
    }
}
