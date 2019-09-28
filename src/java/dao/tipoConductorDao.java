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
import modelo.tipoConductor;
import modelo.vehiculo;

/**
 *
 * @author sebas
 */
public class tipoConductorDao {
        //Metodos para operaciones del CRUD
    
    //medoto INSERT
    public static boolean insertartipConductor(tipoConductor cond){
        try {
            Connection conex = librConexion.conectarDB();
            String SQLQueryinsertVehi = "INSERT INTO tipoconductor (idtipoCon,nombre) VALUES(?,?)";
            PreparedStatement ps = conex.prepareStatement(SQLQueryinsertVehi);
            ps.setInt(1,cond.getIdtipoCon());            
            ps.setString(2,cond.getNombre());            
            
            return ps.executeUpdate()> 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
        public static ArrayList<tipoConductor> listartipoConductor(){
        try {
            String SQLQueryListartipoconductor = "SELECT *FROM tipoconductor";
            Connection conex = librConexion.conectarDB();
            PreparedStatement ps = conex.prepareStatement(SQLQueryListartipoconductor);
            ResultSet resultadoListartipConductor = ps.executeQuery();
            ArrayList<tipoConductor> ListartipoConduc = new ArrayList<>();
            tipoConductor TipoConductor;
            
            while(resultadoListartipConductor.next()){
                TipoConductor = new tipoConductor();
                TipoConductor.setIdtipoCon(resultadoListartipConductor.getInt("idtipoCon"));
                TipoConductor.setNombre(resultadoListartipConductor.getString("nombre"));
                ListartipoConduc.add(TipoConductor);
            }
            return ListartipoConduc;
            
        } catch (SQLException ex) {
            return null;
        }
    }
}
