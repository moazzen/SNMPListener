package com.mzn.snmp.SNMPListener.listener;

import com.mzn.snmp.SNMPListener.props.AppConfProps;
import org.snmp4j.*;
import org.snmp4j.smi.UdpAddress;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SNMPv2Listener {

    private final SNMPTrapProcessor snmpTrapProcessor;
    private final AppConfProps appConfProps;

    private TransportMapping transport;
    private String listeningAddress;
    private Snmp snmp;

    public SNMPv2Listener(SNMPTrapProcessor snmpTrapProcessor, AppConfProps appConfProps) {
        this.listeningAddress = appConfProps.getTrapAddress();
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        this.snmpTrapProcessor = snmpTrapProcessor;
        this.appConfProps = appConfProps;
    }

    private void start() throws IOException {
        UdpAddress udpAddress = new UdpAddress(this.listeningAddress);
        transport = new DefaultUdpTransportMapping(udpAddress);
        snmp = new Snmp(transport);
        transport.listen();
        CommandResponder pduHandler = new CommandResponder() {
            public synchronized void processPdu(CommandResponderEvent e) {
                PDU pdu = e.getPDU();
                if (pdu != null) {
                    try {

                        //process PDU object : building json and sending to rabbitMQ
                        snmpTrapProcessor.process(pdu);


                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        };
        snmp.addCommandResponder(pduHandler);
    }

    public void stop() throws IOException {
        snmp.close();
    }
}
