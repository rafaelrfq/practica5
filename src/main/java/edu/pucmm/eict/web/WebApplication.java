package edu.pucmm.eict.web;

import edu.pucmm.eict.web.jms.Consumidor;
import edu.pucmm.eict.web.jms.MensajeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.jms.JMSException;

@SpringBootApplication
public class WebApplication {
    @Autowired
    MensajeServices mensajeServices;

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @PostConstruct
    public void jms() throws JMSException {
        new Consumidor(mensajeServices).conectar();
    }
}