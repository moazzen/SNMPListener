package com.mzn.snmp.SNMPListener.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mzn.snmp.SNMPListener.conf.RabbitMQSenderService;
import com.mzn.snmp.SNMPListener.props.AppConfProps;
import org.snmp4j.PDU;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class SNMPTrapProcessor {

    private final SNMPUtil snmpUtil;
    private final RabbitMQSenderService rabbitMQSenderService;
    private final AppConfProps appConfProps;
    private final MessageProperties messageProperties;

    public SNMPTrapProcessor(SNMPUtil snmpUtil, RabbitMQSenderService rabbitMQSenderService, AppConfProps appConfProps, MessageProperties messageProperties) {
        this.snmpUtil = snmpUtil;
        this.rabbitMQSenderService = rabbitMQSenderService;
        this.appConfProps = appConfProps;
        this.messageProperties = messageProperties;
    }

    public void process(PDU pdu) throws JsonProcessingException {
        //building json from pdu object
        String snmpTrapJson = snmpUtil.buildJSONFromPDUObject(pdu);
        //send to rabbit
        Message message = new Message(snmpTrapJson.getBytes(StandardCharsets.UTF_8), messageProperties);
        rabbitMQSenderService.sendToRabbitQueue(appConfProps.getSnmpExchange(), appConfProps.getSnmpRoutingKey(), message);
    }
}
