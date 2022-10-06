package com.mzn.snmp.SNMPListener.conf;

import com.mzn.snmp.SNMPListener.props.AppConfProps;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final AppConfProps appConfProps;

    public RabbitMQConfig(AppConfProps appConfProps) {
        this.appConfProps = appConfProps;
    }


    //============================================================================================================================
    //============================================================================================================================
    //============================================================================================================================


    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(appConfProps.getRabbitHost());
        cachingConnectionFactory.setUsername(appConfProps.getRabbitUsername());
        cachingConnectionFactory.setPassword(appConfProps.getRabbitPassword());
        cachingConnectionFactory.setVirtualHost(appConfProps.getRabbitVirtualHost());
        cachingConnectionFactory.createConnection().createChannel(true);
        return cachingConnectionFactory;
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
