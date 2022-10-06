package com.mzn.snmp.SNMPListener.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties("app-config")
public class AppConfProps {

    private String trapAddress;
    private String rabbitHost;
    private String rabbitPassword;
    private String rabbitUsername;
    private String rabbitVirtualHost;
    private String snmpExchange;
    private String snmpRoutingKey;

    public String getTrapAddress() {
        return trapAddress;
    }

    public void setTrapAddress(String trapAddress) {
        this.trapAddress = trapAddress;
    }

    public String getRabbitHost() {
        return rabbitHost;
    }

    public void setRabbitHost(String rabbitHost) {
        this.rabbitHost = rabbitHost;
    }

    public String getRabbitPassword() {
        return rabbitPassword;
    }

    public void setRabbitPassword(String rabbitPassword) {
        this.rabbitPassword = rabbitPassword;
    }

    public String getRabbitUsername() {
        return rabbitUsername;
    }

    public void setRabbitUsername(String rabbitUsername) {
        this.rabbitUsername = rabbitUsername;
    }

    public String getRabbitVirtualHost() {
        return rabbitVirtualHost;
    }

    public void setRabbitVirtualHost(String rabbitVirtualHost) {
        this.rabbitVirtualHost = rabbitVirtualHost;
    }

    public String getSnmpExchange() {
        return snmpExchange;
    }

    public void setSnmpExchange(String snmpExchange) {
        this.snmpExchange = snmpExchange;
    }

    public String getSnmpRoutingKey() {
        return snmpRoutingKey;
    }

    public void setSnmpRoutingKey(String snmpRoutingKey) {
        this.snmpRoutingKey = snmpRoutingKey;
    }
}
