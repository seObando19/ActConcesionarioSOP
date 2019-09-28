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
public class contrato implements Serializable{
    private int idContrato,idConductor;
    private String placaVehi;
    
    public contrato(){
        this.idContrato=0;
        this.idConductor=0;
        this.placaVehi="";
    }

    public contrato(int idContrato, int idConductor, String placaVehi) {
        this.idContrato = idContrato;
        this.idConductor = idConductor;
        this.placaVehi = placaVehi;
    }   

    public int getIdContrato() {
        return idContrato;
    }

    public void setIdContrato(int idContrato) {
        this.idContrato = idContrato;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public String getPlacaVehi() {
        return placaVehi;
    }

    public void setPlacaVehi(String placaVehi) {
        this.placaVehi = placaVehi;
    }
    
    
    
}
