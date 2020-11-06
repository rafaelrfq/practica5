package edu.pucmm.eict.web.jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumidor {
    MensajeServices mensajeServices;
    ActiveMQConnectionFactory factory;
    Connection connection;
    Session session;
    Topic topic;
    MessageConsumer consumer;

    public Consumidor(MensajeServices mensajeServices) {
        this.mensajeServices = mensajeServices;
    }

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
                objectMapper.registerModule(new JavaTimeModule());
                String json = msg.getText();
                MensajeJson mensaje = objectMapper.readValue(json, MensajeJson.class);
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
