package com.mzn.snmp.SNMPListener.listener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.snmp4j.PDU;
import org.snmp4j.smi.VariableBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SNMPUtil {

    private final ObjectMapper objectMapper;

    public SNMPUtil(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public String buildJSONFromPDUObject(PDU pdu) throws JsonProcessingException {
        HashMap<String, String> snmpMap = new HashMap<>();
        for (int i = 0; i < pdu.getVariableBindings().size(); ++i) {
            VariableBinding variableBinding = pdu.getVariableBindings().get(i);
            snmpMap.put(variableBinding.getOid().toString(), variableBinding.getVariable().toString());
        }

        return objectMapper.writeValueAsString(snmpMap);
    }
}
