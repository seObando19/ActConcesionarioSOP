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
public class tipoConductor implements Serializable{
    private int idtipoCon;
    private String nombre;
    
    public tipoConductor(){
        this.idtipoCon=0;
        this.nombre="";
    }

    public tipoConductor(int idtipoCon, String nombre) {
        this.idtipoCon = idtipoCon;
        this.nombre = nombre;
    }

    public int getIdtipoCon() {
        return idtipoCon;
    }

    public void setIdtipoCon(int idtipoCon) {
        this.idtipoCon = idtipoCon;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
