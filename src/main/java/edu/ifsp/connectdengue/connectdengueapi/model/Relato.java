package edu.ifsp.connectdengue.connectdengueapi.model;

import edu.ifsp.connectdengue.connectdengueapi.DatabaseRelato;

public class Relato {
    protected long idRelato;
    protected String nome;
    protected String experiencia;
    protected String localicacaoEstado;
    protected String relato;
    
    public Relato() {
    }

    public Relato(long idRelato, String nome, String experiencia, String localicacaoEstado, String relato) {
        this.idRelato = idRelato;
        this.nome = nome;
        this.experiencia = experiencia;
        this.localicacaoEstado = localicacaoEstado;
        this.relato = relato;
    }

    public void addDado(DatabaseRelato databaseRelatoDados){
        databaseRelatoDados.relatos.add(this);
    }

    public long getIdRelato() {
        return idRelato;
    }

    public void setIdRelato(long idRelato) {
        this.idRelato = idRelato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getLocalicacaoEstado() {
        return localicacaoEstado;
    }

    public void setLocalicacaoEstado(String localicacaoEstado) {
        this.localicacaoEstado = localicacaoEstado;
    }

    public String getRelato() {
        return relato;
    }

    public void setRelato(String relato) {
        this.relato = relato;
    }

}
