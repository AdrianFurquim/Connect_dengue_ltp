package edu.ifsp.connectdengue.connectdengueapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsp.connectdengue.connectdengueapi.model.Relato;
import edu.ifsp.connectdengue.connectdengueapi.model.RelatoDAO;

@RestController
public class ControllerRelato {

    @GetMapping("/dengue/relatos")
    public List<Relato> verRelatos() {
        RelatoDAO relatosDados = RelatoDAO.getInstance();
        List<Relato> relatos = relatosDados.findAll();
        return relatos;
    }

    @GetMapping("/dengue/relatos/{id}")
    public Relato verRelatosProcura(@PathVariable("id") long idRelato) {

        RelatoDAO relatoDados = RelatoDAO.getInstance();
        List<Relato> relatos = relatoDados.findAll();
        for (Relato relato : relatos) {
            if (relato.getIdRelato() == idRelato) {
                return relato;
            }
        }
        return null;
    }

    @PostMapping("/dengue/relatos/incerir")
    public List<Relato> incerirRelatoIncerir(@RequestBody List<Relato> relatosList) {

        RelatoDAO relatoDados = RelatoDAO.getInstance();
        List<Relato> relatos = relatoDados.findAll();
        int existente = 0;

        for (Relato relatoFor : relatos) {
            for (Relato relatoList : relatosList) {
                if (relatoList.getIdRelato() == relatoFor.getIdRelato()) {
                    existente++;
                    break;
                }
            }
        }

        if (existente > 0) {
            return null;
        } else {
            for (Relato relatoList : relatosList) {
                relatoDados.create(relatoList);
            }
            return null;
        }
    }

    @DeleteMapping("/dengue/relatos/remove/{id}")
    public Relato removerRelato(@PathVariable("id") long idRelato) {

        RelatoDAO relatoDados = RelatoDAO.getInstance();
        List<Relato> relatos = relatoDados.findAll();
    
        Relato relatoParaRemover = null;
    
        for (Relato relato : relatos) {
            if (relato.getIdRelato() == idRelato) {
                relatoParaRemover = relato;
                break; // Encontrou o relato, pode sair do loop.
            }
        }
        
        if (relatoParaRemover != null) {
            relatoDados.delete(relatoParaRemover);
        }
        
        return null;
    }
}
