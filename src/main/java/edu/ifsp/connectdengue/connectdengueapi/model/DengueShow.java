package edu.ifsp.connectdengue.connectdengueapi.model;

import edu.ifsp.connectdengue.connectdengueapi.DatabaseDengueShow;

public class DengueShow {
    protected int idQuiz;
    protected String[] respostas = new String[5];
    protected int pontuacao;

    public DengueShow(){
        
    }

    public DengueShow(int idQuiz, String[] respostas, int pontuacao) {
        this.idQuiz = idQuiz;
        this.respostas = respostas;
        this.pontuacao = pontuacao;
    }
      public void addDado(DatabaseDengueShow database){
        database.quizes.add(this);
    }

    public int getIdQuiz() {
        return idQuiz;
    }

    public void setIdQuiz(int id_quiz) {
        this.idQuiz = id_quiz;
    }

    public String[] getRespostas() {
        return respostas;
    }

    public void setRespostas(String[] respostas) {
        this.respostas = respostas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    
}
