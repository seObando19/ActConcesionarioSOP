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
    //Metodo listar
    public static ArrayList<conductor>listarConductor(){
        try {
            String SQLQueryListarConductor = "SELECT *FROM conductor";
            Connection conex = librConexion.conectarDB();
            PreparedStatement st = conex.prepareStatement(SQLQueryListarConductor);
            ResultSet resultadoListarCond = st.executeQuery();
            ArrayList<conductor> listarConductor = new ArrayList<>();
            conductor Conductor;
            
            while(resultadoListarCond.next()){
                Conductor = new conductor();
                Conductor.setIdConductor(resultadoListarCond.getInt("idConductor"));
                Conductor.setNombre(resultadoListarCond.getString("nombre"));
                Conductor.setTipoLicencia(resultadoListarCond.getString("tipoLicencia"));
                Conductor.setPlacaVehi(resultadoListarCond.getString("placaVehi"));
                Conductor.setIdtipoCond(resultadoListarCond.getInt("idTipoCond"));
                listarConductor.add(Conductor);
            }
            return listarConductor;
        } catch (SQLException ex) {
            return null;
        }
    }
    //Metodo para mostrar los conductores en la vista de contratos
    public static String getConductores(int idConductor){
        try {
            String sqlCotForCod = "select nombre from conductor where idConductor=?";
            Connection conex = librConexion.conectarDB();
            PreparedStatement st = conex.prepareStatement(sqlCotForCod);
            
            //Enviar el parametro idConductor
            st.setInt(1, idConductor);
            ResultSet resultado = st.executeQuery();
            
            //Verificar si existen os idConductor y traer su nombre
            if(resultado.next()){
                return resultado.getString("nombre");
            }
            return "---";
        } catch (SQLException ex) {
            return "---";
        }
    }
        
}
