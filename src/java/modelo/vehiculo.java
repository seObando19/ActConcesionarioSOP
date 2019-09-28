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
public class vehiculo implements Serializable{
    private int idTipoV,modelo;
    private String placaVehi,marca,referencia;
    
    public vehiculo(){
        this.idTipoV=0;
        this.marca="";
        this.modelo=0;
        this.placaVehi="";
        this.referencia="";
    }

    public vehiculo(int idTipoV, int modelo, String placaVehi, String marca, String referencia) {
        this.idTipoV = idTipoV;
        this.modelo = modelo;
        this.placaVehi = placaVehi;
        this.marca = marca;
        this.referencia = referencia;
    }

    public int getIdTipoV() {
        return idTipoV;
    }

    public void setIdTipoV(int idTipoV) {
        this.idTipoV = idTipoV;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getPlacaVehi() {
        return placaVehi;
    }

    public void setPlacaVehi(String placaVehi) {
        this.placaVehi = placaVehi;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
}
