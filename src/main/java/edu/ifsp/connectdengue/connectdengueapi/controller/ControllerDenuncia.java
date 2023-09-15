package edu.ifsp.connectdengue.connectdengueapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.ifsp.connectdengue.connectdengueapi.model.Denuncia;
import edu.ifsp.connectdengue.connectdengueapi.model.DenunciaDAO;
import edu.ifsp.connectdengue.connectdengueapi.model.Relato;
import edu.ifsp.connectdengue.connectdengueapi.model.RelatoDAO;


    @RestController
    public class ControllerDenuncia{

    @GetMapping("/dengue/denuncias")
    public List<Denuncia> verDenuncias() {
        DenunciaDAO denunciaDado = DenunciaDAO.getInstance();
        List<Denuncia> denuncias = denunciaDado.findAll();
        return denuncias;
    }
    
    @GetMapping("/dengue/denuncias/{id}")
    public Denuncia verDenunciasProcura(@PathVariable("id") long idDenuncia) {

        DenunciaDAO denunciaDado = DenunciaDAO.getInstance();
        List<Denuncia> denuncias = denunciaDado.findAll();
        for (Denuncia denuncia : denuncias) {
            if (denuncia.getIdDenuncia() == idDenuncia) {
             return denuncia;
            }
        }
        return null;
    }

     @PostMapping("/dengue/denuncias/inserir")
     public List<Denuncia> inserirDenunciaInserir(@RequestBody List<Denuncia> denunciasList) {

        DenunciaDAO denunciaDado = DenunciaDAO.getInstance();
        List<Denuncia> denuncias = denunciaDado.findAll();
        int existente = 0;

        for (Denuncia denunciaFor : denuncias) {
            for (Denuncia denunciaList : denunciasList) {
                if (denunciaList.getIdDenuncia() == denunciaFor.getIdDenuncia()) {
                    existente++;
                    break;
                }
            }
        }

        if (existente > 0) {
            return null;
        } else {
            for (Denuncia denunciaList : denunciasList) {
                denunciaDado.create(denunciaList);
            }
            return null;
        }
    }

     @DeleteMapping("/dengue/denuncias/remove/{id}")
     public Denuncia removerDenuncia(@PathVariable("id") long idDenuncia) {
        
        DenunciaDAO denunciaDado = DenunciaDAO.getInstance();
        List<Denuncia> denuncias = denunciaDado.findAll();
        for (Denuncia denuncia : denuncias) {
                if(denuncia.getIdDenuncia() == idDenuncia){
                denunciaDado.delete(denuncia);
                return denuncia;
            }else{
                
            }
        }
        return null;
    }
}
    