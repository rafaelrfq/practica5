package edu.pucmm.eict.web.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jms.*;

public class Consumidor {
    @Autowired MensajeServices mensajeServices;
    ActiveMQConnectionFactory factory;
    Connection connection;
    Session session;
    Topic topic;
    MessageConsumer consumer;

    public Consumidor() { }

    public void conectar() throws JMSException {

        factory = new ActiveMQConnectionFactory("admin", "admin", "failover:tcp://servidor:61616");

        connection = factory.createConnection();
        connection.start();

        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        topic = session.createTopic("notificacion_sensores");
        consumer = session.createConsumer(topic);
        consumer.setMessageListener(message -> {
            try {
                TextMessage msg = (TextMessage) message;
                System.out.println("Mensaje recibido: \n\n" + msg.getText());
                ObjectMapper objectMapper = new ObjectMapper();
                MensajeJson mensaje = objectMapper.readValue(msg.getText(), MensajeJson.class);
                mensajeServices.crearMensaje(mensaje);
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
