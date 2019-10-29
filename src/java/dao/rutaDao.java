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
import modelo.ruta;
import modelo.vehiculo;

/**
 *
 * @author sebas
 */
public class rutaDao {
    
        //Metodos para operaciones del CRUD
    
    //medoto INSERT
    public static boolean insertarRuta(ruta rut){
        try {
            Connection conex = librConexion.conectarDB();            
            String SQLQueryinsertRuta = "INSERT INTO ruta (idRuta,estacion,idVehi) VALUES(?,?,?)";
            PreparedStatement ps = conex.prepareStatement(SQLQueryinsertRuta);
            ps.setInt(1,rut.getIdRuta());
            ps.setString(2,rut.getEstacion());
            ps.setString(3,rut.getPlacaVehi());
            
            return ps.executeUpdate()> 0;
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
        public static ArrayList<ruta> listarRuta(){
        try {
            String SQLQueryListarRuta = "SELECT *FROM ruta";
            Connection conex = librConexion.conectarDB();
            PreparedStatement ps = conex.prepareStatement(SQLQueryListarRuta);
            ResultSet resultadoListarRuta = ps.executeQuery();
            ArrayList<ruta> ListarRuta = new ArrayList<>();
            ruta Ruta;
            
            while(resultadoListarRuta.next()){
                Ruta = new ruta();
                Ruta.setIdRuta(resultadoListarRuta.getInt("idRuta"));                        
                Ruta.setEstacion(resultadoListarRuta.getString("estacion"));
                Ruta.setPlacaVehi(resultadoListarRuta.getString("placaVehi"));
                ListarRuta.add(Ruta);
            }
            return ListarRuta;
            
        } catch (SQLException ex) {
            return null;
        }
    }
}
