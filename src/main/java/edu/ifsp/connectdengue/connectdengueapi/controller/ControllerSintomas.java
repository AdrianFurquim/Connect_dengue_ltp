package edu.ifsp.connectdengue.connectdengueapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsp.connectdengue.connectdengueapi.model.Relato;
import edu.ifsp.connectdengue.connectdengueapi.model.RelatoDAO;
import edu.ifsp.connectdengue.connectdengueapi.model.Sintomas;
import edu.ifsp.connectdengue.connectdengueapi.model.SintomasDAO;


@RestController
public class ControllerSintomas {
    @GetMapping("/dengue/sintomas")
    public List<Sintomas> verSintomas() {
        SintomasDAO sintomasDados = SintomasDAO.getInstance();
        List<Sintomas> sintomas = sintomasDados.findAll();
        return sintomas;
    }

    @PostMapping("/dengue/sintomas/inserir")
    public Sintomas incerirSintomas(@RequestBody Sintomas sintoma) {

        SintomasDAO sintomasDados = SintomasDAO.getInstance();

        List<Sintomas> sintomas = sintomasDados.findAll();
        int existente = 0;
        for (Sintomas sintomasFor : sintomas) {
            if(sintoma.getIdSintomas() == sintomasFor.getIdSintomas()){
                existente++;
            }
        }
        if(existente > 0){
            return null;
        }else{
            sintomasDados.create(sintoma);
            return sintoma;
        }
        
    }


@DeleteMapping("/dengue/sintomas/remove/{id}")
    public Sintomas removerSintomas(@PathVariable("id") long idSintomas) {
        
        SintomasDAO sintomasDados = SintomasDAO.getInstance();
        List<Sintomas> sintomas = sintomasDados.findAll();
        for (Sintomas sintoma : sintomas) {
            if(sintoma.getIdSintomas() == idSintomas){
                sintomasDados.delete(sintoma);
                return sintoma;
            }
        }
        return null;
    }
}
