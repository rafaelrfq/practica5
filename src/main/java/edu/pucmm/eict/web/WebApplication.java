package edu.pucmm.eict.web;

import edu.pucmm.eict.web.jms.Consumidor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
        try {
            new Consumidor().conectar();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
