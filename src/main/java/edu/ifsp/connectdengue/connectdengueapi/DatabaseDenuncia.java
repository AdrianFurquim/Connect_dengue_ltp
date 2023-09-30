package edu.ifsp.connectdengue.connectdengueapi;

import java.util.ArrayList;
import java.util.List;

import edu.ifsp.connectdengue.connectdengueapi.model.Denuncia;

public class DatabaseDenuncia {
    public static ArrayList<Denuncia> denuncias;

    public static void init(){
        denuncias = new ArrayList<Denuncia>();
        denuncias.add(new Denuncia(24.00, 24.00, "Sao Paulo", "Itatiba"));
    }

    public void addDadoDenuncia(Denuncia novo){
        denuncias.add(novo);
    }

    public static ArrayList<Denuncia> recuperarDadoDenuncia(){
        return denuncias;
    }

    public void removeDadosDenuncia(Denuncia delete){
        denuncias.remove(delete);
    }
    public static List<Denuncia> all(){
        return denuncias;
    }
}
