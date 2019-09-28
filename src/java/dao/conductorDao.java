/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.conductor;

/**
 *
 * @author sebas
 */
public class conductorDao {
    
    //Metodos para operaciones del CRUD
    
    //medoto INSERT
    public static boolean insertarConductor(conductor cond){        
        try {
            Connection conex = librConexion.conectarDB();
            String SQLQueryinsertCond = "INSERT INTO (idConductor,nombre,tipoLicencia,placaVehi,idTipoCond) VALUES(?,?,?,?,?)";
            PreparedStatement ps = conex.prepareStatement(SQLQueryinsertCond);
            ps.setInt(1, cond.getIdConductor());
            ps.setString(2, cond.getNombre());
            ps.setString(3, cond.getTipoLicencia());
            ps.setString(4, cond.getPlacaVehi());
            ps.setInt(5,cond.getIdtipoCond());
            
            return ps.executeUpdate()>0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
        
}
