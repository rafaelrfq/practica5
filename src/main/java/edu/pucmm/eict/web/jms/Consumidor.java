package edu.pucmm.eict.web.jms;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumidor {
    ActiveMQConnectionFactory factory;
    Connection connection;
    Session session;
    Topic topic;
    MessageConsumer consumer;

    public Consumidor() { }

    public void conectar() throws JMSException {

        factory = new ActiveMQConnectionFactory("admin", "admin", "failover:tcp://localhost:61616");

        connection = factory.createConnection();
        connection.start();

        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        consumer = session.createConsumer(topic);
        consumer.setMessageListener(message -> {
            try {
                TextMessage msg = (TextMessage) message;
                System.out.println("Mensaje recibido: \n\n" + msg.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public void cerrarConexion() throws JMSException {
        connection.stop();
        connection.close();
    }
}
