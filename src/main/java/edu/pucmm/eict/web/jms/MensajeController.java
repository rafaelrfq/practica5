package edu.pucmm.eict.web.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MensajeController {
    @Autowired MensajeServices mensajeServices;

    @GetMapping("")
    public String home(){
        return "home";
    }

    @GetMapping("list")
    public String listarMensajes(Model model){
        model.addAttribute("mensajes", mensajeServices.findAllMensajes());
        return "list";
    }

    @GetMapping("graphs")
    public String graficas(Model model){
        List<Mensaje> listado = mensajeServices.findAllMensajes();
        float tempDisp1[], tempDisp2[], humDisp1[], humDisp2[];
        int indiceDisp1 = 0, indiceDisp2 = 0;
        tempDisp1 = new float[]{0,0,0,0,0};
        tempDisp2 = new float[]{0,0,0,0,0};
        humDisp1 = new float[]{0,0,0,0,0};
        humDisp2 = new float[]{0,0,0,0,0};

        for (Mensaje m : listado) {
            if (m.getIdDispositivo() == 1){
                tempDisp1[indiceDisp1] = m.getTemperatura();
                humDisp1[indiceDisp1] = m.getHumedad();
                indiceDisp1++;
            } else if (m.getIdDispositivo() == 2){
                tempDisp2[indiceDisp2] = m.getTemperatura();
                humDisp2[indiceDisp2] = m.getHumedad();
                indiceDisp2++;
            }
        }

        model.addAttribute("tempDisp1", tempDisp1);
        model.addAttribute("tempDisp2", tempDisp2);
        model.addAttribute("humDisp1", humDisp1);
        model.addAttribute("humDisp2", humDisp2);
        return "graphs";
    }
}