package edu.ifsp.connectdengue.connectdengueapi;

import java.util.ArrayList;
import java.util.List;

import edu.ifsp.connectdengue.connectdengueapi.model.Sintomas;

public class DatabaseSintomas {
     public static ArrayList<Sintomas> sintomas;

    public static void init(){
        sintomas = new ArrayList<Sintomas>();
        sintomas.add(new Sintomas( "Eder", "febre", "forte"));
    }

    public void addDadoSintomas(Sintomas novo){
        sintomas.add(novo);
    }

    public static ArrayList<Sintomas> recuperarDadoSintomas(){
        return sintomas;
    }

    public void removeDadosSintomas(Sintomas delete){
        sintomas.remove(delete);
    }
    
    public static List<Sintomas> all(){
        return sintomas;
    }
}

