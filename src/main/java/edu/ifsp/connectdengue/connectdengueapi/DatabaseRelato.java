package edu.ifsp.connectdengue.connectdengueapi;

import java.util.ArrayList;
import java.util.List;

import edu.ifsp.connectdengue.connectdengueapi.model.Relato;

public class DatabaseRelato {
    public static ArrayList<Relato> relatos;

    public static void init(){
        relatos = new ArrayList<Relato>();
        relatos.add(new Relato(0, "Teste", "Teste", "Teste", "Teste"));
    }

    public void addDadoRelato(Relato novo){
        relatos.add(novo);
    }

    public static ArrayList<Relato> recuperarDadoRelato(){
        return relatos;
    }

    public void removeDadosRelato(Relato delete){
        relatos.remove(delete);
    }
    
    public static List<Relato> all(){
        return relatos;
    }
}
