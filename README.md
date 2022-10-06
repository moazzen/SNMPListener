# SNMPListener
Listen SNMP traps messages and send to rabbitMQ broker

## What is SNMP Traps
**Simple Network Management Protocol (SNMP) Traps** are alert messages sent from a remote SNMP-enabled device to a central collector, the "SNMP manager". In more technical terms, SNMP Traps are asynchronous, unpacked messages used to notify an entity in your network management system, i.e. central management, of significant issues and events.

## How to run this project
This project created on a spring boot, and you can simply run it like other spring boot applications.

## Change application properties
- ### trapAddress
  This project must run on the trap receiver machine and that's why I use **0.0.0.0** address <br/>
  SNMP Traps used port 162 by default, but you can change it <br/>

- ### rabbitHost
  Set RabbitMQ host address in this properties
  
- ### rabbitUsername
  Set RabbitMQ username in this properties

- ### rabbitPassword
  Set RabbitMQ password in this properties

- ### rabbitVirtualHost
  Set RabbitMQ virtual host in this properties

- ### snmpExchange
  You Should set your queue exchange value in this properties

- ### snmpRoutingKey
  You Should set your queue routing key value in this properties

## Get In Touch
You can follow me on GitHub or email me at the email listed on my GitHub profile.


