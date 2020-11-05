package edu.pucmm.eict.web.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensajeServices {

    @Autowired
    private MensajeRepository mensajeRepository;

    public void crearMensaje(MensajeJson msg){
        Mensaje mensaje = new Mensaje();
        mensaje.setFechaGeneracion(msg.getFechaGeneracion());
        mensaje.setHumedad(msg.getHumedad());
        mensaje.setIdDispositivo(msg.getIdDispositivo());
        mensaje.setTemperatura(msg.getTemperatura());
        mensajeRepository.save(mensaje);
    }

    public Mensaje findMensajeById(long id){
        return mensajeRepository.findByIdNotNull(id);
    }

    public List<Mensaje> findAllMensajes(){
        return mensajeRepository.findAll();
    }
}
