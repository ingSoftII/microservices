package ar.edu.fcyt.ingsoftII.sales.service;


import ar.edu.fcyt.ingsoftII.commons.messaging.QueueConstants;
import ar.edu.fcyt.ingsoftII.commons.messaging.QueueEvents;
import ar.edu.fcyt.ingsoftII.commons.messaging.QueueMessage;
import ar.edu.fcyt.ingsoftII.sales.persistence.domain.Sale;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService {

    private static final Logger log = LoggerFactory.getLogger(PublishService.class);


    private RabbitTemplate rabbitTemplate;

    @Autowired
    public PublishService(final RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void notifySalesCreated(Sale sale) {
        QueueMessage message = new QueueMessage();
        message.setEventName(QueueEvents.SALE_CREATED);
        message.setData(sale.getId());
        log.info("About to send message: {}" ,sale.getId());
        rabbitTemplate.convertAndSend(QueueConstants.EXCHANGE_NAME, QueueConstants.ROUTING_KEY, message);
        log.info("Sent Message");

    }
}
