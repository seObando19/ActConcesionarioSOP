/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.contrato;

/**
 *
 * @author sebas
 */
public class contratoDao {
    
    public static boolean insertarContrato(contrato cont){
        try {
            Connection conex = librConexion.conectarDB();
            String SQLQueryinsertContra = "INSERT INTO contrato (idContrato,placaVehi,idConductor) VALUES (?,?,?)";
            PreparedStatement ps = conex.prepareStatement(SQLQueryinsertContra);
            ps.setInt(1, cont.getIdContrato());
            ps.setString(2, cont.getPlacaVehi());
            ps.setInt(3, cont.getIdConductor());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static ArrayList<contrato> listarContrato(){
        try {
            String SQLQueryListarContrato ="SELECT *FROM contrato";
            Connection conex = librConexion.conectarDB();
            PreparedStatement ps = conex.prepareStatement(SQLQueryListarContrato);
            ResultSet resultadolistarCont = ps.executeQuery();
            ArrayList<contrato> ListarContrato = new ArrayList<>();
            contrato Contrato;
            
            while(resultadolistarCont.next())
            {
                Contrato = new contrato();
                Contrato.setIdContrato(resultadolistarCont.getInt("idContrato"));
                Contrato.setPlacaVehi(resultadolistarCont.getString("placaVehi"));
                Contrato.setIdConductor(resultadolistarCont.getInt("idConductor"));
                ListarContrato.add(Contrato);
            }
            return ListarContrato;
        } catch (SQLException ex) {
            return null;
        }
    }
}
