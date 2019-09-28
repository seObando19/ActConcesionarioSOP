/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author sebas
 */
public class conductor {
    private int  idConductor,idtipoCond;
    private String nombre,tipoLicencia,placaVehi;
    
    public conductor(){
        this.idConductor=0;
        this.idtipoCond=0;
        this.nombre="";
        this.placaVehi="";
        this.tipoLicencia="";
    }

    public conductor(int idConductor, int idtipoCond, String nombre, String tipoLicencia, String placaVehi) {
        this.idConductor = idConductor;
        this.idtipoCond = idtipoCond;
        this.nombre = nombre;
        this.tipoLicencia = tipoLicencia;
        this.placaVehi = placaVehi;
    }

    public int getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(int idConductor) {
        this.idConductor = idConductor;
    }

    public int getIdtipoCond() {
        return idtipoCond;
    }

    public void setIdtipoCond(int idtipoCond) {
        this.idtipoCond = idtipoCond;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(String tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }

    public String getPlacaVehi() {
        return placaVehi;
    }

    public void setPlacaVehi(String placaVehi) {
        this.placaVehi = placaVehi;
    }
    
    
    
}
