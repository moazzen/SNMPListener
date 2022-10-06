package com.mzn.snmp.SNMPListener.conf;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQSenderService {

    private final RabbitTemplate rabbitTemplateTest;
    private final RabbitTemplate rabbitTemplateProd;

    public RabbitMQSenderService(@Qualifier("rabbitTemplate") RabbitTemplate rabbitTemplateTest, @Qualifier("rabbitTemplateProd") RabbitTemplate rabbitTemplateProd) {
        this.rabbitTemplateTest = rabbitTemplateTest;
        this.rabbitTemplateProd = rabbitTemplateProd;
    }

    public void sendToRabbitQueue(String exchange, String routingKey, Message message){
        rabbitTemplateProd.convertAndSend(exchange, routingKey, message);
    }

}
