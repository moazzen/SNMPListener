package com.mzn.snmp.SNMPListener.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.charset.StandardCharsets;

@Configuration
public class GeneralBeans {

    @Bean
    public ObjectMapper objectMapper () {
        return new ObjectMapper();
    }

    @Bean
    MessageProperties messageProperties () {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setContentType(MessageProperties.CONTENT_TYPE_JSON);
        messageProperties.setContentEncoding(StandardCharsets.UTF_8.toString());
        return messageProperties;
    }

}
