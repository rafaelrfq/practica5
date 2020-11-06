package edu.pucmm.eict.web.jms;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.*;
import java.time.LocalDateTime;

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
                String json = msg.getText();
                JsonNode jsonNode = objectMapper.readTree(json);
                MensajeJson mensaje = new MensajeJson();
                mensaje.setFechaGeneracion(LocalDateTime.parse(jsonNode.get("fechaGeneracion").asText()));
                mensaje.setIdDispositivo(Integer.parseInt(jsonNode.get("idDispositivo").asText()));
                mensaje.setHumedad(Float.parseFloat(jsonNode.get("humedad").asText()));
                mensaje.setTemperatura(Float.parseFloat(jsonNode.get("temperatura").asText()));
                // MensajeJson mensaje = objectMapper.readValue(msg.getText(), MensajeJson.class);
                System.out.println(mensaje.getFechaGeneracion().toString());
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
