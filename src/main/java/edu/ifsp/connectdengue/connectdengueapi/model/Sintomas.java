package edu.ifsp.connectdengue.connectdengueapi.model;

public class Sintomas {
    private int idSintomas;
    private String nome;
    private String descricao;
    private String intensidade;

    public Sintomas(){

    }
    
    public Sintomas(int idSintomas, String nome, String descricao, String intensidade) {
        this.idSintomas = idSintomas;
        this.nome = nome;
        this.descricao = descricao;
        this.intensidade = intensidade;
    }


    public int getIdSintomas() {
        return idSintomas;
    }


    public void setIdSintomas(int idSintomas) {
        this.idSintomas = idSintomas;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }


    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


    public String getIntensidade() {
        return intensidade;
    }


    public void setIntensidade(String intensidade) {
        this.intensidade = intensidade;
    }
     
    


}
