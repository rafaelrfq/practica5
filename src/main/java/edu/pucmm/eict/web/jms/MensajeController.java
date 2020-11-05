package edu.pucmm.eict.web.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MensajeController {
    @Autowired MensajeServices mensajeServices;

    @GetMapping("/")
    public String listarMensajes(Model model){
        model.addAttribute("mensajes", mensajeServices.findAllMensajes());
        return "list";
    }
}
