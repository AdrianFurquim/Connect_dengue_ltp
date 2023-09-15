package edu.ifsp.connectdengue.connectdengueapi.model;

import java.util.ArrayList;

import edu.ifsp.connectdengue.connectdengueapi.DatabaseDengueShow;

public class DengueShowDAO {

    private DatabaseDengueShow db;
    private static DengueShowDAO instance;

    // O construtor privado garante que uma única instância irá existir
    private DengueShowDAO(){
       
    }

    // Recupera a única instância do DAO
    public static DengueShowDAO getInstance(){
        if(instance == null){
            instance = new DengueShowDAO();
        }
        return instance;
    }

    // Recupera a conexão com o Banco de Dados
    private DatabaseDengueShow getConnection(){
        if(this.db == null){            
            DatabaseDengueShow db = new DatabaseDengueShow();
            this.db = db;
        }
        return this.db;    
    }

    //Cria um novo cadastro
    public void create(DengueShow novo){
        DatabaseDengueShow db = getConnection();
        db.addDadoDengueShow(novo);
    }   

    // Recupera todas as listas
    public ArrayList<DengueShow> read(){
        DatabaseDengueShow db = getConnection();
        return db.recuperarDadoQuiz();
    }

    public void delete(DengueShow showDelete){
        DatabaseDengueShow db = getConnection();
        db.removeDadosDengueShow(showDelete);
    }

    public void update(DengueShow toUpdate){
        // Sem implementação
    }

    public ArrayList<DengueShow> findAll(){

        return (ArrayList<DengueShow>) DatabaseDengueShow.all();
    }
}