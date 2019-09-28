/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;

/**
 *
 * @author sebas
 */
public class ruta implements Serializable{
    private int idRuta;
    private String estacion;
    private String placaVehi;
    
    public ruta(){
        this.idRuta=0;
        this.estacion="";
        this.placaVehi="";
    }

    public ruta(int idRuta, String estacion, String placaVehi) {
        this.idRuta = idRuta;
        this.estacion = estacion;
        this.placaVehi = placaVehi;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public String getPlacaVehi() {
        return placaVehi;
    }

    public void setPlacaVehi(String placaVehi) {
        this.placaVehi = placaVehi;
    }
    
    
    
}
