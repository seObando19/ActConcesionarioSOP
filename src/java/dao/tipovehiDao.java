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
import modelo.tipovehi;

/**
 *
 * @author sebas
 */
public class tipovehiDao {
    //Metodos para las operaciones CRUD
    
    //metodo insert
    public static boolean insertartv(tipovehi tv)
    {
        try {
            Connection cone = librConexion.conectarDB();
            String SQLQueryInsertv = "INSERT INTO tipovehi (idTV,nomTv) VALUES(?,?) ";
            PreparedStatement ps = cone.prepareStatement(SQLQueryInsertv);
            ps.setInt(1, tv.getIdtv());
            ps.setString(2, tv.getNomtv());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException ex) {
            return false;
        }
    }
    
    //Metodo Listar
    public static ArrayList<tipovehi> listartv()
    {
        try {
            String SQLQueryListarTv = "SELECT *FROM tipovehi";
            Connection conex = librConexion.conectarDB();
            PreparedStatement st = conex.prepareStatement(SQLQueryListarTv);
            ResultSet resultadoListarTv = st.executeQuery();
            ArrayList<tipovehi> listaTv = new ArrayList<>();
            tipovehi TipoVehi;
            
            while(resultadoListarTv.next()){
                TipoVehi = new tipovehi();
                TipoVehi.setIdtv(resultadoListarTv.getInt("idTV"));
                TipoVehi.setNomtv(resultadoListarTv.getString("nomTv"));
                listaTv.add(TipoVehi);
            }
            return listaTv;
            
        } catch (SQLException ex) {
            return null;
        }
    } 
    
    
}
