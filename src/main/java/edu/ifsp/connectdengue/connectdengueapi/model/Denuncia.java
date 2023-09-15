package edu.ifsp.connectdengue.connectdengueapi.model;

import edu.ifsp.connectdengue.connectdengueapi.DatabaseDenuncia;
import edu.ifsp.connectdengue.connectdengueapi.DatabaseRelato;

public class Denuncia {
    protected long idDenuncia;
    protected double latitude;
    protected double longitude;
    protected String estado;
    protected String municipio;
    
    

    public Denuncia() {
    }


    public Denuncia(long idDenuncia, double latitude, double longitude, String estado, String municipio) {
        this.idDenuncia = idDenuncia;
        this.latitude = latitude;
        this.longitude = longitude;
        this.estado = estado;
        this.municipio = municipio;
    }


    public long getIdDenuncia() {
        return idDenuncia;
    }


    public void setIdDenuncia(long idDenuncia) {
        this.idDenuncia = idDenuncia;
    }


    public double getLatitude() {
        return latitude;
    }


    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public double getLongitude() {
        return longitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }


    public String getEstado() {
        return estado;
    }


    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getMunicipio() {
        return municipio;
    }


    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
}
    

