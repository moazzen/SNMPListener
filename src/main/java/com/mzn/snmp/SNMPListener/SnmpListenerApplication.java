package com.mzn.snmp.SNMPListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.SpringProperties;

@SpringBootApplication(scanBasePackages = "com.mzn")
public class SnmpListenerApplication {

	static {//don't wait for jndi
		SpringProperties.setProperty("spring.jndi.ignore", "true");
	}

	public static void main(String[] args) {
		SpringApplication.run(SnmpListenerApplication.class, args);
	}

}
