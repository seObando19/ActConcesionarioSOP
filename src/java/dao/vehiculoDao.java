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
import modelo.vehiculo;

/** 
 *
 * @author sebas
 */
public class vehiculoDao {
    
    //Metodos para operaciones del CRUD
    
    //medoto INSERT
    public static boolean insertarVehiculo(vehiculo veh){
        try {
            Connection conex = librConexion.conectarDB();
            String SQLQueryinsertVehi = "INSERT INTO vehiculo (placaVehi,marca,referencia,modelo,idTipoV) VALUES(?,?,?,?,?)";
            PreparedStatement ps = conex.prepareStatement(SQLQueryinsertVehi);
            ps.setString(1, veh.getPlacaVehi());
            ps.setString(2,veh.getMarca());
            ps.setString(3,veh.getReferencia());
            ps.setInt(4,veh.getModelo());
            ps.setInt(5,veh.getIdTipoV());
            
            return ps.executeUpdate()> 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static ArrayList<vehiculo> listarVehiculo(){
        try {
            String SQLQueryListarVehi = "SELECT *FROM vehiculo";
            Connection conex = librConexion.conectarDB();
            PreparedStatement ps = conex.prepareStatement(SQLQueryListarVehi);
            ResultSet resultadoListarVehi = ps.executeQuery();
            ArrayList<vehiculo> ListarVehiculo = new ArrayList<>();
            vehiculo Vehiculo;
            
            while(resultadoListarVehi.next()){
                Vehiculo = new vehiculo();
                Vehiculo.setPlacaVehi(resultadoListarVehi.getString("placaVehi"));
                Vehiculo.setMarca(resultadoListarVehi.getString("marca"));
                Vehiculo.setReferencia(resultadoListarVehi.getString("referenciaVehi"));
                Vehiculo.setModelo(resultadoListarVehi.getInt("modelo"));
                Vehiculo.setIdTipoV(resultadoListarVehi.getInt("idTipoV"));
                ListarVehiculo.add(Vehiculo);
            }
            return ListarVehiculo;
            
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public static boolean  actualizarvehi(vehiculo veh){
        try {
            Connection conex = librConexion.conectarDB();
            String SQL = "UPDATE vehiculo SET " +
                          "     marca=?," +
                          "     referencia=?," +
                          "     modelo=?," +
                          "     idTipoV=?" +
                          "     WHERE placaVehi=?";
            PreparedStatement st = conex.prepareStatement(SQL);
            
            st.setString(5, veh.getPlacaVehi());
            st.setString(1, veh.getMarca());
            st.setString(2, veh.getReferencia());
            st.setInt(3, veh.getModelo());
            st.setInt(4, veh.getIdTipoV());
            
            if(st.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean eliminarVehi(vehiculo veh){
        try {
            Connection conex = librConexion.conectarDB();
            String SQL = "DELETE FROM vehiculo WHERE placaVehi=?";
            PreparedStatement st = conex.prepareStatement(SQL);
            st.setString(1, veh.getPlacaVehi());
            
            if(st.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public static boolean eliminarVehiuno(String placaVehi ){
        String SQL = "delete from vehiculo where placaVehi="+placaVehi;
        try {
            Connection conex = librConexion.conectarDB();            
            PreparedStatement st = conex.prepareStatement(SQL);            
            
            if(st.executeUpdate() > 0){
                return true;
            }else{
                return false;
            }
            
        } catch (SQLException ex) {
            return false;
        }
    }
}
