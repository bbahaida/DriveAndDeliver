package net.bmbsolutions.driveanddeliver.messaging;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PublishAggregateAspect {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Autowired
    public PublishAggregateAspect(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @AfterReturning("execution(* org.springframework.data.jpa.repository.JpaRepository+.save(..)) && args(entity)")
    public void publishAggregateAfterSave(Object entity) {
        PublishAggregate annotation = entity.getClass().getAnnotation(PublishAggregate.class);
        if (annotation != null) {
            String topic = annotation.topic();
            kafkaTemplate.send(topic, entity);
        }
    }
}